package dk.kea.goodcompany.grilld.reservation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ReservationController {

    private ReservaitionRepo reservaitionRepo;

    public ReservationController(ReservaitionRepo reservaitionRepo) {
        this.reservaitionRepo = reservaitionRepo;
    }

    @GetMapping("/reservation")
    public String showPage(Model model){
        model.addAttribute("orderTableForm", new ReservationTable());
        return "reservation";
    }

    @PostMapping("/reservation")
    public String saveOne(@ModelAttribute ReservationTable ReservationTable){
        ReservationTable.setAmountOfPersons(ReservationTable.getAmountOfPersons());
        ReservationTable.setBooked_on(ReservationTable.getBooked_on());
        ReservationTable.setTelephone(ReservationTable.getTelephone());
        this.reservaitionRepo.save(ReservationTable);
        return "redirect:/reservation";
    }

}
