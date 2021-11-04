package services.impl;

import daos.impl.jdbc.JDBCMySQLExamDAO;
import org.junit.Test;
import services.AbstractExamService;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class DefaultExamServiceTest {

    @Test
    public void testServiceeCreation() throws SQLException, ClassNotFoundException {
        AbstractExamService examService;
        Exception gotException = null;

        try {
            examService = new DefaultExamService(new JDBCMySQLExamDAO());
        } catch (Exception e) {
            gotException = e;
        }

        assertEquals(null, gotException);
    }
}
