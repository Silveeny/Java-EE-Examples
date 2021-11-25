package services.impl;

import beans.Exam;
import scheduler.data.Session;
import scheduler.impl.DefaultExamScheduler;
import services.AbstractExamService;
import services.AbstractTimeTableService;

import java.util.List;

public class DefaultTimeTableService extends AbstractTimeTableService {

    public DefaultTimeTableService(AbstractExamService examServiceProvider) {
        super(examServiceProvider);
    }

    @Override
    public Session scheduleExams() {
        List<Exam> exams = this.examService.getAll();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return (new DefaultExamScheduler()).computeExamSessions(exams);
    }
}
