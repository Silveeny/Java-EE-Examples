package beans;

import daos.impl.jdbc.JDBCMySQLChoicesDAO;
import daos.impl.jdbc.JDBCMySQLExamDAO;
import daos.impl.jdbc.JDBCMySQLStudentDAO;
import services.AbstractChoichesService;
import services.AbstractExamService;
import services.AbstractStudentService;
import services.impl.DefaultChoicheesService;
import services.impl.DefaultExamService;
import services.impl.DefaultStudentService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "student")
@RequestScoped
public class Student {
    private int id;
    private String name;
    private AbstractExamService examService;
    private List<Exam> selectedExams;
    private List<Exam> availableExams = new ArrayList<>();


    // for the converter https://stackoverflow.com/questions/25934498/primefaces-selectmanycheckbox
    //Populeaza lista cu examene - pt alege din ele
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
            // Primefaces should have done this automatically - this is a workaround - please check these question - nobody replies to the actual problem
            // https://stackoverflow.com/questions/69799076/primefaces-selectmanycheckbox-not-being-populated-in-bean
            // https://forum.primefaces.org/viewtopic.php?f=3&t=69357
            selectedExams = examService.getRandom();

            AbstractStudentService studentService = new DefaultStudentService(new JDBCMySQLStudentDAO());
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
