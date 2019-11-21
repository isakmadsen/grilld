package dk.kea.goodcompany.grilld.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecurityController {

    int logInAccess;

    public SecurityController() {

    }

    @GetMapping("/login")
    public String getLoginPage() {

        logInAccess = 0;

        return "security/login";
    }

    @PostMapping("/login")
    public String checkLogIn(@RequestParam("username") String username, @RequestParam("password") String password) {

        username = username.trim().toLowerCase();
        password = password.trim().toLowerCase();

        if (username.equals("customer") && password.equals("1234")) {
            logInAccess = 1;
            return (username + "/account").toString();
        } else if (username.equals("manager") && password.equals("1234")) {
            logInAccess = 2;
            return (username + "/account").toString();
        } else {
            return "redirect:/login";
        }
    }


}
