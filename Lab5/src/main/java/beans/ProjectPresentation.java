package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PROJECT_PRESENTATION")
public class ProjectPresentation extends Exam {

    @Column
    public String bibliography;
}
