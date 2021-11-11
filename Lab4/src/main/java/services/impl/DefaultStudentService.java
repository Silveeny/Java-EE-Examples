package services.impl;

import beans.Student;
import daos.StudentDAO;
import services.AbstractStudentService;

public class DefaultStudentService extends AbstractStudentService {

    public DefaultStudentService(StudentDAO studentDAOProvider) {
        super(studentDAOProvider);
    }

    @Override
    public void save(Student student) {
        this.studentDAO.persistStudent(student);
    }
}
