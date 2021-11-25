package converters;

import beans.Student;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "studentConverter", forClass = Student.class)
public class StudentConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
        if (value != null) {
            return component.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext ctx, UIComponent component, Object value) {
        if (value != null && value instanceof Student) {
            Student student = (Student) value;

            if (student.getName() != null) {
                component.getAttributes().put(student.getName(), value);
                return student.getName();
            }
        }
        return null;
    }
}