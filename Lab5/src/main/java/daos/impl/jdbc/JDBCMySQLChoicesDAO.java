package daos.impl.jdbc;

import beans.Exam;
import beans.Student;
import daos.ChoicesDAO;

import java.sql.*;

public class JDBCMySQLChoicesDAO implements ChoicesDAO {

    private Connection connection;

    public JDBCMySQLChoicesDAO() throws ClassNotFoundException, SQLException {

        // various aws coonfig errors arrise if we
		String url = "jdbc:mysql://database-2.c815gmlhm5vp.us-east-1.rds.amazonaws.com:3306/lab3?autoReconnect=true&useSSL=false";
		String user = "admin";
		String password = "javalab3";

		//load driver communication of postgresql.
		Class.forName("com.mysql.cj.jdbc.Driver");
		//open the connection
		this.connection = DriverManager.getConnection(url, user, password);
	}


    @Override
    public void persistChoice(Student student) {
        String sql = "insert into CHOICES(id_student, id_exam) values (?, ?)";

        PreparedStatement ps;
        try {

            for (Exam exam : student.getSelectedExams()) {
                ps = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, student.getId());
                ps.setInt(2, exam.getId());

                ps.executeUpdate();

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
