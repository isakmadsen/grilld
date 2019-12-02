package dk.kea.goodcompany.grilld.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private HttpSession session;

    @Autowired
    private LoginRepository loginRepo;


    @GetMapping("/logout")
    public String logout() {
        session.removeAttribute("logged");
        session.removeAttribute("auth_type");
        session.removeAttribute("auth_name");
        return "redirect:/admin";
    }

    @GetMapping("/admin")
    public String getLogin(Login login, Model model) {
        model.addAttribute("loginForm", login);
        return "login";
    }

    @PostMapping("/admin")
    public String login(@ModelAttribute Login login) {

        Login checkLogin = loginRepo.findByNameAndPassword(login.getName(), login.getPassword());
        login.setType(checkLogin.getType());

        if (checkLogin.getName().equals(login.getName()) && checkLogin.getPassword().equals(login.getPassword())) {
            session.setAttribute("logged", true);
            session.setAttribute("auth_type", login.getType());
            session.setAttribute("auth_name", login.getName());
            if (login.getType().equals("admin")) {
                //return "redirect:/admin/dishes";
                return "redirect:/menu";
            } else if (login.getType().equals("employee")) {
                //return "redirect:/admin/takeaways";
                return "redirect:/";
            } else {
                //TODO - Customer section
                return "redirect:/";
            }
        } else {
            return "redirect:/admin";
        }
    }
}

