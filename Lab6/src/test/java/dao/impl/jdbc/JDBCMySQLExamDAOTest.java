package dao.impl.jdbc;

import beans.Exam;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JDBCMySQLExamDAOTest {

    @Test
    public void testExamCreation() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Exam exam1 = new Exam("Tehnologii_Java", 1, 20);
        JDBCMySQLExamDAO mySQLExamDAO = new JDBCMySQLExamDAO();
        Exception gotException = null;
        try {
            mySQLExamDAO.persistExam(exam1);
        } catch (Exception e) { gotException = e; }

        assertEquals(null, gotException);
    }

    @Test
    public void testGetAllExams() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<Exam> allExams = null;
        JDBCMySQLExamDAO mySQLExamDAO = new JDBCMySQLExamDAO();

        allExams = mySQLExamDAO.getAllExam();

        assertEquals(2, allExams.size());
    }

}
