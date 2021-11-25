package beans;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@ManagedBean(name = "search")
@RequestScoped
public class SearchBean {

    @Transient
    @PersistenceContext(unitName="Lab5_PU")
    EntityManager em;



    public String searchString;

    public Integer duration;

    public Boolean checkDuration;

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Boolean getCheckDuration() {
        return checkDuration;
    }

    public void setCheckDuration(Boolean checkDuration) {
        this.checkDuration = checkDuration;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public void submit() {

        // result not rendered to UI yet
        List<Exam> exams = exams = findByCriteria(duration, searchString);
        System.out.println(exams);
    }

    public List<Exam> findByCriteria(Integer duration, String search) {
        // criteria api din lab slides
        if (em == null) {
            em = Persistence.createEntityManagerFactory("Lab5_PU").createEntityManager();
        }


        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Exam> query = builder.createQuery(Exam.class);

        Root<Exam> exam = query.from(Exam.class);

        Predicate filter = builder.conjunction();

        if(duration != null)   {
            filter = builder.and(filter, builder.equal(exam.get("duration"), duration));
        }

        query.where(filter);

        filter = builder.and(filter, builder.equal(exam.get("name"), search));

        query.where(filter);


        TypedQuery<Exam> q = em.createQuery(query);
        List<Exam> result = q.getResultList();

        return result;
    }

}
