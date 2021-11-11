package beans;

import daos.impl.jdbc.JDBCMySQLExamDAO;
import services.AbstractExamService;
import services.impl.DefaultExamService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.SQLException;
// Anotarile din curs sunt deprecated - eu le las asa.
@ManagedBean(name = "exam")
@RequestScoped
public class Exam {
    private int id;
    private String name;
    private int start;
    private int duration;


    public Exam() {
    }

    public Exam(String name, int start, int duration) {
        this.name = name;
        this.start = start;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void submit() {
        AbstractExamService examService = null;
        try {
            examService = new DefaultExamService(new JDBCMySQLExamDAO());
            examService.save(this);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
