package lab7.repository.impl.jpa;

import lab7.entities.User;
import lab7.repository.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.*;
import java.io.Serializable;
// The @ApplicationScoped is here so we can treat the repo as a bean
@ApplicationScoped
public class JPAUserRepositoryImpl implements UserRepository, Serializable {

    @PersistenceContext
    EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(User user) {
        if (entityManager == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Lab7_PU");
            entityManager = emf.createEntityManager();
        }

        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }
    // This is done since it might crash without it
    @Override
    public User get(String username) {
        if (entityManager == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Lab7_PU");
            entityManager = emf.createEntityManager();
        }

        // getEntityManager()

        Query query = entityManager.createQuery("select user from User user where user.username = :search"); // JPQL
        query.setParameter("search", username);
        return (User) query.getResultList().get(0);
    }

    //this generates the em associated with the persistance unit that we defined in persistance.xml - from lecture notes
    @Produces
    @ApplicationScoped
    public EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Lab7_PU");
        entityManager = emf.createEntityManager();
        return entityManager;
    }

}
