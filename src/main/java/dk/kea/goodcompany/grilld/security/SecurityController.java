package dk.kea.goodcompany.grilld.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecurityController {

    // Manager = 1; Staff = 2; Customer = 3
    int logInAccess;

    public SecurityController() {
        logInAccess = 0;
    }

    @GetMapping("/login/{accountType}")
    public String getLoginPage(@PathVariable("accountType") int type) {

        logInAccess = type;

        return "security/login";
    }

    @PostMapping("/login")
    public String checkLogIn(@RequestParam("username") String username, @RequestParam("password") String password) {

        username = username.trim().toLowerCase();
        password = password.trim().toLowerCase();

        //TODO - SecurityController - Implement a way to check the database for account details

        switch (logInAccess) {
            case 1:
                if (username.equals("manager") && password.equals("1234"))
                    return ("platform_users/" + username + "/account");
                else return ("redirect:/login/" + logInAccess);
            case 2:
                if (username.equals("staff") && password.equals("1234"))
                    return ("platform_users/" + username + "/account");
                else return ("redirect:/login/" + logInAccess);
            case 3:
                if (username.equals("customer") && password.equals("1234"))
                    return ("platform_users/" + username + "/account");
                else return ("redirect:/login/" + logInAccess);
            default: {
                logInAccess = 0;
                return "redirect:/";
            }
        }
    }
}
