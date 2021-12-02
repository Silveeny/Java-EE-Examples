package lab7.services.authentication;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lab7.entities.User;
// bean that holds all users that are logged in - stackoverflow might be wrong on some of these
@ApplicationScoped
public class LoginCache implements Serializable {
    private List<String> loggedInUsers = new ArrayList<String>();
    // stream instead of for's - it is faster.
    public boolean isLoggedIn(User user) {
        return loggedInUsers
            .stream()
            .filter(lu -> lu.equals(user.getUsername()))
            .collect(Collectors.toList()).size() == 0;
    }

    public boolean isLoggedIn(String username) {
        return loggedInUsers
            .stream()
            .filter(lu -> lu.equals(username))
            .collect(Collectors.toList()).size() == 0;
    }


    public void loginUser(User user) {
        boolean isLoggedInUser = isLoggedIn(user);

        if (!isLoggedInUser) {
            loggedInUsers.add(user.getUsername());
        }
    }

}
