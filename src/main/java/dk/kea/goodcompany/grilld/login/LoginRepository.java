package dk.kea.goodcompany.grilld.login;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface LoginRepository extends Repository<Login, Integer>{


}
