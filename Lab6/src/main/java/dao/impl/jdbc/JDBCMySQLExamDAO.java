package dao.impl.jdbc;

import beans.Exam;
import dao.ExamDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCMySQLExamDAO implements ExamDAO {

	private Connection connection;

    public JDBCMySQLExamDAO() throws ClassNotFoundException, SQLException {

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
    public void persistExam(Exam exam) {
        String sql = "insert into EXAM(name, start, duration) values (?, ?, ?)";

        PreparedStatement ps;
        try {
            ps = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // 1 = first '?'
            ps.setString(1, exam.getName());
            // 2 - second '?'
            ps.setInt(2, exam.getStart());
            // 3 = third '?'
            ps.setInt(3, exam.getDuration());

            //use execute update when the database return nothing
            ps.executeUpdate();

            ResultSet generatedKeys =  ps.getGeneratedKeys();
            if(generatedKeys.next()) {
                exam.setId(generatedKeys.getInt(1));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Exam> getAllExam() {
        String sql = "select * from EXAM";
        PreparedStatement ps;

        List<Exam> allExams = null;

        try {

            ps = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            allExams = new ArrayList<>();
            while (rs.next()) {
                Exam exam = new Exam(rs.getString("name"), rs.getInt("start"),
                    rs.getInt("duration"));

                exam.setId(rs.getInt("id"));

                allExams.add(exam);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return allExams;
    }
}
