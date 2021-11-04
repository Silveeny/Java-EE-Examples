package daos;

import beans.Student;

/**
 * Interacts with an association table in RDS MariaDB (id, user_id, exam_id) - interfaces instead of clases are easier to use with JPA later
 */
public interface ChoicesDAO {
    void persistChoice(Student student);
}
