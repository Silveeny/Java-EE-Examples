package lab7.services.authentication;

import lab7.repository.UserRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import lab7.entities.User;


@SessionScoped
public class AuthenticationService implements Serializable {

    @Inject
    LoginCache LoginCache;

    @Inject
    UserRepository userRepository;

    @Inject
    CurrentUser CurrentUser;

    public void authenticate(String username, String password) {
        User user = userRepository.get(username);
        if (!LoginCache.isLoggedIn(user)) {
            if (user.getPassword().equals(password)) {
                LoginCache.loginUser(user);
                CurrentUser.setUser(user);
            }
        }

        // hack - islogged in if might be bugged - this makes sure the auth service works
        if (user.getPassword().equals(password)) {
            LoginCache.loginUser(user);
            CurrentUser.setUser(user);
        }
    }
    // check user rank - so he can see documents
    public boolean canViewDocs() {
        return CurrentUser.getUser().getRank().equals("admin");
    }
}
