package daos.impl.jpa;

import beans.Exam;
import daos.ExamDAO;

import javax.ejb.Stateful;
import javax.persistence.*;
import java.util.List;

public class JPAExamDAO implements ExamDAO {
    @PersistenceContext(unitName="Lab5_PU")
    private EntityManager em;


    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
    public void persistExam(Exam exam) {
        em.persist(exam);
    }

    @Override
    public List<Exam> getAllExam() {
        Query query = em.createQuery("select exam from Exam exam"); // JPQL
        return query.getResultList();
    }
}
