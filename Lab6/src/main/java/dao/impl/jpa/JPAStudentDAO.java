package dao.impl.jpa;

import beans.Student;
import dao.StudentDAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

public class JPAStudentDAO implements StudentDAO {


    private EntityManager em;

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
    public void persistStudent(Student student) {
        em.persist(student);
    }
}
