package lab7.repository.impl.jpa;

import lab7.entities.Document;
import lab7.repository.DocumentRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@ApplicationScoped
public class JPADocumentRepositoryImpl implements DocumentRepository, Serializable {

    @PersistenceContext
    EntityManager entityManager;
    // same as JPAUser
    @Override
    public void save(Document document) {
        if (entityManager == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Lab7_PU");
            entityManager = emf.createEntityManager();
        }

        entityManager.getTransaction().begin();
        entityManager.persist(document);
        entityManager.getTransaction().commit();

    }
    // This is so you can get all documents from the db
    public List<Document> getAll() {
        if (entityManager == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Lab7_PU");
            entityManager = emf.createEntityManager();
        }

        Query query = entityManager.createQuery("select d from Document d");
        List<Document> documents = query.getResultList();
        return documents;
    }


    @Override
    public Document get(String code) {
        return null;
    }

    @Produces
    @ApplicationScoped
    public EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Lab7_PU");
        entityManager = emf.createEntityManager();
        return entityManager;
    }


}
