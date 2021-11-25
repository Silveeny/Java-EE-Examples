package ejb;

import beans.Exam;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.*;

@Interceptors({PerformanceInterceptor.class})
@Stateless
public class SecondLevelCache {

    @PersistenceContext(unitName="Lab5_PU")
    EntityManager em;

    public void doTest() {
        if (em == null) {
            em = Persistence.createEntityManagerFactory("Lab5_PU").createEntityManager();
        }

        Cache cache = em.getEntityManagerFactory().getCache();
        cache.contains(Exam.class, 2);
        // interceptor will profile the running time
    }
}
