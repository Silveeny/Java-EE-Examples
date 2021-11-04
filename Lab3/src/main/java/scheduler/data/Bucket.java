package scheduler.data;

import beans.Exam;

public class Bucket {
    private Exam[] exams = {
        new Exam(),
        new Exam(),
        new Exam()
    };

    private int bucketIndex = 0;

    public Bucket() { }

    public boolean isFull() {
        return bucketIndex == 3;
    }

    public void addExam(Exam exam) {
        exams[bucketIndex++] = exam;
    }

    public boolean isOverlapping(Exam exam) {
        return exam.getStart() < exams[bucketIndex].getDuration();
    }

    public Exam[] getExams() {
        return exams;
    }

    public void setExams(Exam[] exams) {
        this.exams = exams;
    }

    @Override
    public String toString() {
        String bucketStringRepresentation = "Exam at " + exams[0].getName() + " starts at " + exams[0].getStart() +
            " and ends at " + exams[0].getDuration() + " ***** ";

        bucketStringRepresentation += "Exam at " + exams[1].getName() + " starts at " + exams[1].getStart() +
            " and ends at " + exams[1].getDuration() + " ***** ";

        bucketStringRepresentation += "Exam at " + exams[2].getName() + " starts at " + exams[2].getStart() +
            " and ends at " + exams[2].getDuration();

        return bucketStringRepresentation;
    }
}
