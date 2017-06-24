package app.Controller;

import app.service.LoginService;

/**
 * Created by pvmeira on 24/06/17.
 */
public class LoginController {
    private LoginService loginService;

    public LoginController() {
        this.loginService = new LoginService();
    }

    public Boolean authenticate(String username, String password) {
        return this.loginService.validateLogin(username, password);
    }

}
