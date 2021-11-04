package services;

import beans.Student;
import daos.StudentDAO;

public abstract class AbstractStudentService {
    protected StudentDAO studentDAO;

    public AbstractStudentService(StudentDAO studentDAOProvider) {
        this.studentDAO = studentDAOProvider;
    }

    abstract public void save(Student student);
}
