package beans;

import dao.impl.jpa.JPAExamDAO;
import services.AbstractExamService;
import services.impl.DefaultExamService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.persistence.*;

@ManagedBean(name = "exam")
@MappedSuperclass
@Cacheable(true)
@Entity
@Table(name = "EXAM")
public class Exam {

    @Transient
    @PersistenceContext(unitName="Lab5_PU")
    EntityManager em;

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "persons_id_seq")
    @GeneratedValue(generator = "sequence")
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "start")
    private int start;

    @Column(name = "duration")
    private int duration;

    @Transient
    private String bibliography;

    @Transient
    private String requiredResources;

    @Transient
    @EJB
    DefaultExamService DefaultExamService;

    public Exam() {
    }

    public Exam(String name, int start, int duration) {
        this.name = name;
        this.start = start;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void submit() {
        AbstractExamService examService = null;

        if (em == null) {
            em = Persistence.createEntityManagerFactory("Lab5_PU").createEntityManager();
        }

        JPAExamDAO jpaExamDAO = new JPAExamDAO();
        jpaExamDAO.setEntityManager(em);
        examService = new DefaultExamService(jpaExamDAO);

        if (!bibliography.equals("")) {
            ProjectPresentation pp = new ProjectPresentation();
            pp.setId(this.getId());
            pp.setName(this.getName());
            pp.setDuration(this.getDuration());
            pp.setStart(this.getStart());
            pp.setBibliography(bibliography);
            examService.save(pp);
        } else if (!requiredResources.equals("")) {
            WrittenTest pp = new WrittenTest();
            pp.setId(this.getId());
            pp.setName(this.getName());
            pp.setDuration(this.getDuration());
            pp.setStart(this.getStart());
            pp.setRequiredResources(requiredResources);
            examService.save(pp);
        } else {
            examService.save(this);
        }
    }


    public String getBibliography() {
        return bibliography;
    }

    public void setBibliography(String bibliography) {
        this.bibliography = bibliography;
    }

    public String getRequiredResources() {
        return requiredResources;
    }

    public void setRequiredResources(String requiredResources) {
        this.requiredResources = requiredResources;
    }

}
