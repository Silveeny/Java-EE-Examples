package ejb;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static javax.ejb.ConcurrencyManagementType.BEAN;

@Stateful
@LocalBean
@ConcurrencyManagement(BEAN)
public class ResourceAllocator {

    @EJB
    InMemoryManager inMemoryManager;

    @EJB
    AvailabilityChecker availabilityChecker;

    public synchronized void takeResource(String resource, Integer examId) {
        if (availabilityChecker.checkAvailability(resource)) {
            inMemoryManager.assignments.put(resource, examId);
        }
    }

    /**
     * @return available resources
     */
    public synchronized List<String> getResources() {
        List<String> retVal = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : inMemoryManager.assignments.entrySet()) {
            if (!entry.getValue().equals(null)) {
                retVal.add(entry.getKey());
            }
        }

        return retVal;
    }

}
