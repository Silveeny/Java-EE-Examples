package daos.impl.jdbc;

import beans.Student;
import daos.StudentDAO;

import java.sql.*;

public class JDBCMySQLStudentDAO implements StudentDAO {

    private Connection connection;

    public JDBCMySQLStudentDAO() throws ClassNotFoundException, SQLException {

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
    public void persistStudent(Student student) {
        String sql = "insert into STUDENT(name) values (?)";

        PreparedStatement ps;
        try {
            ps = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // 1 = first '?'
            ps.setString(1, student.getName());

            //use execute update when the database return nothing
            ps.executeUpdate();

            ResultSet generatedKeys =  ps.getGeneratedKeys();
            if(generatedKeys.next()) {
                student.setId(generatedKeys.getInt(1));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
