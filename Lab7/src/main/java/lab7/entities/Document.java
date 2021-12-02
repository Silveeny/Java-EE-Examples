package lab7.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DOCUMENT")
public class Document implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer id;

    @Column
    public String code;

    @Lob
    // content is byte array - so we can store in db easier
    @Column(length=100000, name = "content")
    private byte[] data;

    public Document() {}

    public Document(String code, String name, byte[] content) {
        this.code = code;
        this.name = name;
        this.data = content;
    }

    @Column
    public String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String uniqueId) {
        this.code = uniqueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

}
