package lab7.services.authentication;

import lab7.entities.User;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
// this keeps user logged in - no log out.
@SessionScoped
public class CurrentUser implements Serializable {

    private User user = null;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
