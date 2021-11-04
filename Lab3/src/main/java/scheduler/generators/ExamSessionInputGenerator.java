package scheduler.generators;

import beans.Exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExamSessionInputGenerator {
    public static List<Exam> generateExams() {
        Random random = new Random();
        List<Exam> exams = new ArrayList<>();
        // Create a random generator that produces problem instances of various sizes and test your algorithm. - generates an exam list
        int limit = random.nextInt(20);
        for (int i  = 0; i < limit; ++i) {
            exams.add(new Exam("Exam" + random.nextInt(20),
                                random.nextInt(10), random.nextInt(20)));
        }

        return exams;
    }

}
