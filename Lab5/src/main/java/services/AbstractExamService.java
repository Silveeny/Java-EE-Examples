package services;

import beans.Exam;
import daos.ExamDAO;

import java.util.List;

public abstract class AbstractExamService {

    protected ExamDAO examDAO;

    public AbstractExamService(ExamDAO examDAOProvider) {
        this.examDAO = examDAOProvider;
    }

    abstract public List<Exam> getAll();
    abstract public List<Exam> getRandom();
    abstract public void save(Exam exam);
}
