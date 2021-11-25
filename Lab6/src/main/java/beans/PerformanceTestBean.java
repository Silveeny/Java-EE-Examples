package beans;

import ejb.EntityGraph;
import ejb.SecondLevelCache;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.util.Timer;
import java.util.TimerTask;

@ManagedBean(name = "performance_test")
@SessionScoped
@Named
public class PerformanceTestBean {

    @EJB
    EntityGraph entityGraph;

    @EJB
    SecondLevelCache secondLevelCache;

    public PerformanceTestBean() {
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("Calling entity graph ===== check interceptor log");
                entityGraph.doTest();
            }
        };
        Timer timer = new Timer("TimerEntityGraph");

        TimerTask task2 = new TimerTask() {
            public void run() {
                System.out.println("Calling second level cache ===== check interceptor log");
                secondLevelCache.doTest();
            }
        };

        long delay = 10000L;
        timer.schedule(task, delay);
        timer.schedule(task2, delay);
    }

}
