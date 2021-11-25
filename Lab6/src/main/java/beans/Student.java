package beans;

import dao.impl.jdbc.JDBCMySQLChoicesDAO;
import dao.impl.jdbc.JDBCMySQLExamDAO;
import dao.impl.jpa.JPAStudentDAO;
import services.AbstractChoichesService;
import services.AbstractExamService;
import services.AbstractStudentService;
import services.impl.DefaultChoicheesService;
import services.impl.DefaultExamService;
import services.impl.DefaultStudentService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "student")
@RequestScoped
@Entity
@Table(name = "STUDENT")
@NamedEntityGraph(name = "graph.Student.name", attributeNodes = @NamedAttributeNode("name"))
public class Student {
    @Transient
    @PersistenceContext(unitName="Lab5_PU")
    private EntityManager em;

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "persons_id_seq")
    @GeneratedValue(generator = "sequence")
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Transient
    private AbstractExamService examService;

    @Transient
    private List<Exam> selectedExams;

    @Transient
    private List<Exam> availableExams = new ArrayList<>();

    @Transient
    @EJB
    DefaultStudentService defaultStudentService;


    // for the converter https://stackoverflow.com/questions/25934498/primefaces-selectmanycheckbox

    public Student() {
        try {
            examService = new DefaultExamService(new JDBCMySQLExamDAO());
            availableExams = examService.getAll();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Exam> getExams() {
        return availableExams;
    }

    public void setExams(List<Exam> exams) {
        this.availableExams = exams;
    }

    public List<Exam> getSelectedExams() {
        return selectedExams;
    }

    public void setSelectedExams(List<Exam> selectedExams) {
        this.selectedExams = selectedExams;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void submit() {
        try {

            selectedExams = examService.getRandom();

            if (em == null) {
                em = Persistence.createEntityManagerFactory("Lab5_PU").createEntityManager();
            }


            JPAStudentDAO jpaStudentDAO = new JPAStudentDAO();
            jpaStudentDAO.setEntityManager(em);

            AbstractStudentService studentService = new DefaultStudentService(jpaStudentDAO);
            AbstractChoichesService choichesService = new DefaultChoicheesService(new JDBCMySQLChoicesDAO());
            studentService.save(this);

            choichesService.save(this);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
