package ejb;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class AvailabilityChecker {

    @EJB
    InMemoryManager inMemoryManager;

    public boolean checkAvailability(String resourceName) {
        if (inMemoryManager.assignments.get(resourceName) == null) {
            return true;
        }
        return false;
    }

}
