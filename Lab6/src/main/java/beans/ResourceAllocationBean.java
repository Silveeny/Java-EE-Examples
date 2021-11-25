package beans;

import ejb.ResourceAllocator;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "resource_allocation")
@SessionScoped
@Named
public class ResourceAllocationBean {

    @EJB
    ResourceAllocator resourceAllocator;

    public List<String> listOfResources;

    public String resourceId;

    public Integer examId;

    public ResourceAllocationBean() {
//        listOfResources = resourceAllocator.getResources();
        listOfResources = new ArrayList<>();
        listOfResources.add("projector-001");
        listOfResources.add("projector-002");
        listOfResources.add("projector-003");
        listOfResources.add("projector-004");
        listOfResources.add("projector-005");
        listOfResources.add("room-001");
        listOfResources.add("room-002");
        listOfResources.add("room-003");
        listOfResources.add("room-004");
        listOfResources.add("room-005");
    }

    public void submit() {
//        resourceAllocator.takeResource(resourceId, examId);
        System.out.println("Resource occupied");

    }

    public List<String> getListOfResources() {
        return listOfResources;
    }

    public void setListOfResources(List<String> listOfResources) {
        this.listOfResources = listOfResources;
    }

        public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }
}
