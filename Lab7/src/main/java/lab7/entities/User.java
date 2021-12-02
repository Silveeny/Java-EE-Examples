package lab7.entities;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "USER2")
@Entity
public class User implements Serializable {

    @Id
    @Column
    // This is so it can generate the id automatically - java handles it
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer id;

    @Column
    public String password;

    @Column
    public String username;

    @Column
    public String rank;

    public User() {}

    public User(String password, String username, String rank) {
        this.password = password;
        this.username = username;
        this.rank = rank;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String name) {
        this.password = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}