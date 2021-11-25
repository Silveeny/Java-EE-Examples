package daos.impl.jpa;

import beans.Exam;
import daos.impl.jdbc.JDBCMySQLExamDAO;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class JPAExamDAOTest {

    @PersistenceContext(unitName="Lab5_PU")
    EntityManager em;

    @Test
    public void testExamCreation() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Exam exam1 = new Exam("Tehnologii_Java", 1, 20);
        Exception gotException = null;

        JPAExamDAO jpaExamDAO = new JPAExamDAO();

        if (em == null) {
            em = Persistence.createEntityManagerFactory("Lab5_PU").createEntityManager();
        }


        jpaExamDAO.setEntityManager(em);

        try {
            em.getTransaction().begin();
            jpaExamDAO.persistExam(exam1);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) { gotException = e; }

        assertEquals(null, gotException);
    }

    @Test
    public void testGetAllExams() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<Exam> allExams = null;
        JPAExamDAO jpaExamDAO = new JPAExamDAO();

        if (em == null) {
            em = Persistence.createEntityManagerFactory("Lab5_PU").createEntityManager();
        }

        jpaExamDAO.setEntityManager(em);

        allExams = jpaExamDAO.getAllExam();

        assertEquals(2, allExams.size());
    }

}
