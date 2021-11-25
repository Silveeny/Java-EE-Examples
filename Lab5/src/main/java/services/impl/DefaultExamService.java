package services.impl;

import beans.Exam;
import daos.ExamDAO;
import services.AbstractExamService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DefaultExamService extends AbstractExamService {

    // old style injection of dependencies
    public DefaultExamService(ExamDAO examDAOImpl) {
        super(examDAOImpl);
    }


    @Override
    public List<Exam> getAll() {
        return this.examDAO.getAllExam();
    }

    @Override
    public List<Exam> getRandom() {
        List<Exam> allExams = getAll();
        Random rand = new Random();
        List<Exam> randExams = new ArrayList<>();

        for (int i = 0; i < allExams.size(); ++i) {
//            if (rand.nextInt(2) % 2 == 0) {
              if (i % 2 == 0) {
                randExams.add(allExams.get(i));
            }
        }

        return randExams;
    }

    @Override
    public void save(Exam exam) {
        this.examDAO.persistExam(exam);
    }
}
