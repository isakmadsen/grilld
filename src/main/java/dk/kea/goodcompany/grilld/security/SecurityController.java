package dk.kea.goodcompany.grilld.security;

import dk.kea.goodcompany.grilld.platform_users.customers.Customer;
import dk.kea.goodcompany.grilld.platform_users.customers.CustomerRepository;
import dk.kea.goodcompany.grilld.platform_users.employee.EmployeeRepository;
import dk.kea.goodcompany.grilld.platform_users.employee.EmployeesEntity;
import dk.kea.goodcompany.grilld.platform_users.manager.ManagerEntity;
import dk.kea.goodcompany.grilld.platform_users.manager.ManagerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecurityController {

    private CustomerRepository customerRepository;
    private EmployeeRepository employeeRepository;
    private ManagerRepository managerRepository;

    // Manager = 1; Staff = 2; Customer = 3
    int logInAccess;

    public SecurityController(CustomerRepository customerRepository, EmployeeRepository employeeRepository, ManagerRepository managerRepository) {
        this.employeeRepository = employeeRepository;
        this.managerRepository = managerRepository;
        this.customerRepository = customerRepository;
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

        //TODO - SecurityController - Implement a way to check the database for account details - done

        switch (logInAccess) {
            case 1: {
                ManagerEntity managerEntity = managerRepository.findByUsername(username);
                if (managerEntity.getUsername().equals(username) && managerEntity.getPassword().equals(password))
                    return ("platform_users/" + "manager" + "/account");
                else return ("redirect:/login/" + logInAccess);
            }
            case 2: {
                EmployeesEntity employeesEntity = employeeRepository.findByUsername(username);
                if (employeesEntity.getUsername().equals(username) && employeesEntity.getPassword().equals(password))
                    return ("platform_users/" + "staff" + "/account");
                else return ("redirect:/login/" + logInAccess);
            }
            case 3: {
                Customer customer = customerRepository.findByUsername(username);
                if (customer.getUsername().equals(username) && customer.getPassword().equals(password))
                    return ("platform_users/" + "customer" + "/account");
                else return ("redirect:/login/" + logInAccess);
            }
            default: {
                logInAccess = 0;
                return "redirect:/";
            }
        }
    }
}
