package services;

import beans.Student;
import dao.StudentDAO;

public abstract class AbstractStudentService {
    protected StudentDAO studentDAO;

    public AbstractStudentService(StudentDAO studentDAOProvider) {
        this.studentDAO = studentDAOProvider;
    }

    abstract public void save(Student student);
}
