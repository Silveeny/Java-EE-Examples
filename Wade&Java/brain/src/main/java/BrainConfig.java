
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
@ApplicationScoped
public class BrainConfig extends Application {
//    /**
//    * Do not modify addRestResourceClasses() method.
//    * It is automatically populated with
//    * all resources defined in the project.
//    * If required, comment out calling this method in getClasses().
//    */
//    private void addRestResourceClasses(Set<Class<?>> resources) {
//        resources.add(Country.class);
//    }
//
//    public Set<Class<?>> getClasses() {
//        Set<Class<?>> resources = new java.util.HashSet<>();
//        addRestResourceClasses(resources);
//        return resources;
//    }
}