package ejb;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

@Interceptors({PerformanceInterceptor.class})
@Stateless
public class EntityGraph {

    @PersistenceContext(unitName="Lab5_PU")
    EntityManager em;

    public void doTest() {
        if (em == null) {
            em = Persistence.createEntityManagerFactory("Lab5_PU").createEntityManager();
        }

        javax.persistence.EntityGraph<?> graph = em.getEntityGraph("graph.Student.name");
            em.createQuery("SELECT s FROM Student s")
            .setHint("javax.persistence.loadgraph", graph)
            .getResultList();

        // interceptor will do the rest (eg profile the running time)
    }
}
