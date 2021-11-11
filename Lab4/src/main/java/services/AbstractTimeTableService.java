package services;

import beans.Exam;
import scheduler.data.Session;

import java.util.List;

public abstract class AbstractTimeTableService {
    protected AbstractExamService examService;

    public AbstractTimeTableService(AbstractExamService examServiceProvider) {
        examService = examServiceProvider;
    }

    abstract public Session scheduleExams();
}
