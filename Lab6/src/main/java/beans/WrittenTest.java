package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "WRITTEN_TEST")
public class WrittenTest extends Exam {

    @Column
    public String requiredResources;

}
