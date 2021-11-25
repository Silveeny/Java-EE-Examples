package dao;

import beans.Student;

/**
 * Interacts with an association table in RDS MariaDB (id, user_id, exam_id)
 */
public interface ChoicesDAO {
    void persistChoice(Student student);
}
