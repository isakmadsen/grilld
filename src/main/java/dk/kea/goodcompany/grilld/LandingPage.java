package dk.kea.goodcompany.grilld;

import org.springframework.web.bind.annotation.GetMapping;

public class LandingPage {

    @GetMapping("/")
    public static String Landing(){
        return "index";
    }
}
