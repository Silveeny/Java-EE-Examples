package beans;

import dao.impl.jdbc.JDBCMySQLExamDAO;
import scheduler.data.Session;
import services.AbstractTimeTableService;
import services.impl.DefaultExamService;
import services.impl.DefaultTimeTableService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.SQLException;

@ManagedBean(name = "timeTable")
@RequestScoped
public class TimeTable {
    public Session examSession;

    public TimeTable() {
        try {
            AbstractTimeTableService timeTableService = new DefaultTimeTableService(
                new DefaultExamService(new JDBCMySQLExamDAO()));

            examSession = timeTableService.scheduleExams();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Session getExamSession() {
        return examSession;
    }

    public void setExamSession(Session examSession) {
        this.examSession = examSession;
    }

}
