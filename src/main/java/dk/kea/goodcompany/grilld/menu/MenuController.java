package dk.kea.goodcompany.grilld.menu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Map;

@Controller
public class MenuController {

    private static final String VIEWS_MENU_CREATE_OR_UPDATE_FORM = "menu/createOrUpdateMenuForm";

    private final MenuRepository menuRepo;


    public MenuController(MenuRepository menuRepo) {
        this.menuRepo = menuRepo;

    }


    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }



    @GetMapping("/menu/find")
    public String initFindForm(Map<String, Object> model) {
        model.put("menu", new Menu());
        return "menu/findMenu";
    }

    @GetMapping("/menu")
    public String processFindForm(Menu menu, BindingResult result, Map<String, Object> model) {

        // allow parameterless GET request for /menu to return all records
        if (menu.getName() == null) {
            menu.setName(""); // empty string signifies broadest possible search
        }

        // find menu by name
//        Collection<Menu> results = this.menuRepo.findMenu();
        Collection<Menu> results = this.menuRepo.findMenuByName(menu.getName());
        if (results.isEmpty()) {
            // no menu found
            result.rejectValue("name", "notFound", "not found");
            return "menu/findMenu";
        } else if (results.size() == 1) {
            // 1 menu found
            menu = results.iterator().next();
            return "redirect:/menu/" + menu.getId();
        } else {
        //   multiple menu found
            model.put("selections", results);
            return "menu/menuList";
        }
    }


    @GetMapping("/menu/{menuId}/edit")
    public String initUpdateMenuForm(@PathVariable("menuId") int menuId, Model model) {
        Menu menu = this.menuRepo.findById(menuId);
        model.addAttribute(menu);
        return VIEWS_MENU_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/menu/{menuId}/edit")
    public String processUpdateDrugForm(@Valid Menu menu, BindingResult result, @PathVariable("menuId") int menuId) {
        if (result.hasErrors()) {
            return VIEWS_MENU_CREATE_OR_UPDATE_FORM;
        } else {
            menu.setId(menuId);
            this.menuRepo.save(menu);
            return "redirect:/menu/{menuId}";
        }
    }

    @GetMapping("/menu/new")
    public String initCreationForm(Map<String, Object> model) {
        Menu menu = new Menu();
        model.put("menu", menu);
        return VIEWS_MENU_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/menu/new")
    public String processCreationForm(@Valid Menu menu, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_MENU_CREATE_OR_UPDATE_FORM;
        } else {
            this.menuRepo.save(menu);
            return "redirect:/menu/" + menu.getId();
        }
    }

    @GetMapping("/menu/{menuId}")
    public ModelAndView showMenu(@PathVariable("menuId") int menuId) {
        ModelAndView mav = new ModelAndView("menu/menuDetails");
        Menu menu = this.menuRepo.findById(menuId);

        mav.addObject(menu);

        return mav;
    }
}
