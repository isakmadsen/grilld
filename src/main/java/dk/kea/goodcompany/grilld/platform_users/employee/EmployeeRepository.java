package dk.kea.goodcompany.grilld.platform_users.employee;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface EmployeeRepository extends Repository<EmployeesEntity, Integer> {

    @Query("SELECT employee FROM EmployeesEntity employee WHERE employee.username = :username")
    @Transactional(readOnly = true)
    EmployeesEntity findByUsername(@Param("username") String username);

    void save(EmployeesEntity employeesEntity);
}
