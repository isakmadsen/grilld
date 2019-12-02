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

    private ReservaitionRepo reservaitionRepo;

    public ReservationController(ReservaitionRepo reservaitionRepo) {
        this.reservaitionRepo = reservaitionRepo;
    }

    @GetMapping("/reservation")
    public String showPage(Model model){
        model.addAttribute("orderTableForm", new OrderTable());
        return "reservation";
    }

    @PostMapping("/reservation")
    public String saveOne(@ModelAttribute OrderTable OrderTable){
        OrderTable.setAmountOfPersons(OrderTable.getAmountOfPersons());
        OrderTable.setBooked_on(OrderTable.getBooked_on());
        OrderTable.setTelephone(OrderTable.getTelephone());
        this.reservaitionRepo.save(OrderTable);
        return "redirect:/reservation";
    }

}
