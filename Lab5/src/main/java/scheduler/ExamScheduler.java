package scheduler;

import beans.Exam;
import scheduler.data.Session;

import java.util.List;

public interface ExamScheduler {
    Session computeExamSessions(List<Exam> exams);
}
