package lab7.beans;

import lab7.services.authentication.AuthenticationService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ManagedBean(name = "login")
@RequestScoped
@Named
public class LoginView {

    @Inject
    public AuthenticationService authenticationService;

    public String username;
    public String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AuthenticationService getAuthenticationService() {
        return authenticationService;
    }

    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public void submit() {
        System.out.println("test");
        authenticationService.authenticate(username, password);
    }

}
