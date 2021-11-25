package dao;

import beans.Exam;

import java.util.List;

public interface ExamDAO {
    void persistExam(Exam exam);
    List<Exam> getAllExam();
}
