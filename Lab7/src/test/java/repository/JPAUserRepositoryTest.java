package repository;

import lab7.entities.User;
import lab7.repository.impl.jpa.JPAUserRepositoryImpl;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static junit.framework.TestCase.assertNull;

public class JPAUserRepositoryTest {

    @Test
    public void testCreateUser() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Lab7_PU");
        EntityManager em = emf.createEntityManager();

        JPAUserRepositoryImpl jpaUserRepository = new JPAUserRepositoryImpl();
        jpaUserRepository.setEntityManager(em);

        User user = new User("1234", "vasile", "admin");

        Exception e = null;

        try {
            jpaUserRepository.save(user);
        } catch (Exception e2) {
            e = e2;
        }

        assertNull(e);

    }

}
