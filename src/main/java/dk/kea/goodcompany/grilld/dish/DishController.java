package dk.kea.goodcompany.grilld.dish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Collection;
import java.util.Map;

@Controller
public class DishController {

    private static final String VIEWS_MENU_CREATE_OR_UPDATE_FORM = "menu/createOrUpdateMenuForm";

    private final DishRepository dishRepo;


    public DishController(DishRepository menuRepo) {
        this.dishRepo = menuRepo;

    }


    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }


    @GetMapping("/menu/find")
    public String initFindForm(Map<String, Object> model) {
        model.put("dish" , new Dish());
        return "menu/findMenu";
    }

    @GetMapping("/menu")
    public String processFindForm(Dish dish , BindingResult result , Map<String, Object> model) {

        // allow parameterless GET request for /menu to return all records
        if (dish.getName() == null) {
            dish.setName(""); // empty string signifies broadest possible search
        }

        // find menu by name
        Collection<Dish> results = this.dishRepo.findDishByName(dish.getName());

        if (results.isEmpty()) {
            // no menu found
            result.rejectValue("name" , "notFound" , "not found");
            return "menu/findMenu";
        } else if (results.size() == 1) {
            // 1 menu found
            dish = results.iterator().next();
            return "redirect:/menu/" + dish.getId();
        } else {
            //   multiple menu found
            model.put("selections" , results);
            return "menu/menuList";
        }

    }


    @GetMapping("/menu/{menuId}/edit")
    public String initUpdateMenuForm(@PathVariable("menuId") int menuId , Model model) {
        Dish dish = this.dishRepo.findById(menuId);
        model.addAttribute(dish);
        return VIEWS_MENU_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/menu/{dishId}/edit")
    public String processUpdateDrugForm(@Valid Dish dish , BindingResult result , @PathVariable("dishId") int dishId) {
        if (result.hasErrors()) {
            return VIEWS_MENU_CREATE_OR_UPDATE_FORM;
        } else {
            dish.setId(dishId);
            this.dishRepo.save(dish);
            return "redirect:/menu/{dishId}";
        }
    }

    @GetMapping("/menu/new")
    public String initCreationForm(Map<String, Object> model) {
        Dish dish = new Dish();
        model.put("dish" , dish);
        return VIEWS_MENU_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/menu/new")
    public String processCreationForm(@Valid Dish menu , BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_MENU_CREATE_OR_UPDATE_FORM;
        } else {
            this.dishRepo.save(menu);
            return "redirect:/menu/" + menu.getId();
        }
    }

    @GetMapping("/menu/{menuId}")
    public ModelAndView showMenu(@PathVariable("menuId") int dishId) {
        ModelAndView mav = new ModelAndView("menu/menuDetails");
        Dish dish = this.dishRepo.findById(dishId);

        mav.addObject(dish);

        return mav;
    }

    @GetMapping("/menurestaurant")
    public String processMenuRestaurant(Map<String, Object> model) {
        Collection<Dish> restaurantResults = this.dishRepo.findDishByType("Restaurant");
        //   multiple menu found
        model.put("restaurant" , restaurantResults);
        return "menu/menuRestaurant";
    }

    @GetMapping("/menutakeaway")
    public String processTARestaurant(Map<String, Object> model) {
        Collection<Dish> takeAwayResults = this.dishRepo.findDishByType("Take Away");
        model.put("takeaway" , takeAwayResults);

        return "menu/menuTakeaway";
    }





}




