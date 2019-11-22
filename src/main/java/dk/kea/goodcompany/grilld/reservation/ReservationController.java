package dk.kea.goodcompany.grilld.reservation;

import org.hibernate.criterion.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class ReservationController {

    @GetMapping("/reservation")
    public String showPage(Model model){
        model.addAttribute("orderTableForm", new OrderTable());
        return "reservation";
    }

    @PostMapping("/reservation")
    public String saveOne(@ModelAttribute OrderTable OrderTable){

        return "redirect:/reservation";
    }
}
