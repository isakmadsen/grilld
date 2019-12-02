package dk.kea.goodcompany.grilld.login;

import org.springframework.data.repository.Repository;

public interface LoginRepository extends Repository<Login, Integer> {

    Login findByNameAndPassword(String name, String password);

    Login findByNameAndType(String name, String type);


}
