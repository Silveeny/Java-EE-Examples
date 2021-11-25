package services.impl;

import beans.Student;
import dao.StudentDAO;
import services.AbstractStudentService;

import javax.ejb.Stateless;

@Stateless
public class DefaultStudentService extends AbstractStudentService {

    public DefaultStudentService(StudentDAO studentDAOProvider) {
        super(studentDAOProvider);
    }

    public DefaultStudentService() {
        super(null);
    }

    @Override
    public void save(Student student) {
        this.studentDAO.persistStudent(student);
    }
}
