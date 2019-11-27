package dk.kea.goodcompany.grilld.platform_users.manager;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ManagerRepository extends Repository<ManagerEntity, Integer> {

    @Query("SELECT manager FROM ManagerEntity manager WHERE manager.username = :username")
    @Transactional(readOnly = true)
    ManagerEntity findByUsername(@Param("username") String username);

    void save(ManagerEntity managerEntity);
}
