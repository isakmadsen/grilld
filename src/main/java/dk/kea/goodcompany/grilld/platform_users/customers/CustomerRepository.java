package dk.kea.goodcompany.grilld.platform_users.customers;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerRepository extends Repository<Customer, Integer> {

    @Query("SELECT customer FROM Customer customer WHERE customer.username =:username")
    //@Query("SELECT FROM customer WHERE customer.username =:username")
    @Transactional(readOnly = true)
    Customer findByUsername(@Param("username") String username);


    void save(Customer customer);
}
