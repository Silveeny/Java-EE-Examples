package scheduler.impl;

import beans.Exam;
import scheduler.ExamScheduler;
import scheduler.data.Bucket;
import scheduler.data.Session;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DefaultExamScheduler implements ExamScheduler {

    @Override
    public Session computeExamSessions(List<Exam> exams) {
        // sort asc dupa start date
        // sortam asc dupa end date

        Comparator<Exam> compareByStart = Comparator.comparingInt(Exam::getStart);
        Comparator<Exam> compareByDuration = Comparator.comparingInt(Exam::getDuration);

        Collections.sort(exams, compareByStart);
        Collections.sort(exams, compareByDuration);

        Session examSession = new Session();
        Bucket[] buckets = examSession.getDays();

        for (int i = 0; i < buckets.length; i++) {

            if (exams.size() == 0) {
                break;
            }

            buckets[i].addExam(exams.get(0));

            for (int j = 0; j < exams.size(); ++j) {
                if (!buckets[i].isOverlapping(exams.get(j))) {
                    buckets[i].addExam(exams.get(j));
                    exams.remove(j);
                }

                if (buckets[i].isFull()) {
                    break;
                }
            }

        }

        examSession.setDays(buckets);

        return examSession;
    }
}
