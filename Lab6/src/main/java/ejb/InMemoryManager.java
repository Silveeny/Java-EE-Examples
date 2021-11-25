package ejb;

import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.Singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static javax.ejb.ConcurrencyManagementType.BEAN;

@Singleton
@ConcurrencyManagement(BEAN)
public class InMemoryManager {

    public Map<String, Integer> assignments = new ConcurrentHashMap<>();

     @PostConstruct
     private synchronized void init() {
        assignments.put("projector-001", null);
        assignments.put("projector-002", null);
        assignments.put("projector-003", null);
        assignments.put("projector-004", null);
        assignments.put("projector-005", null);
        assignments.put("room-001", null);
        assignments.put("room-002", null);
        assignments.put("room-003", null);
        assignments.put("room-004", null);
        assignments.put("room-005", null);
     }

}
