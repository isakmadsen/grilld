package dk.kea.goodcompany.grilld.menu;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

public interface MenuRepository extends Repository<Menu, Integer> {
    @Query("SELECT DISTINCT menu FROM Menu menu WHERE menu.name LIKE :name%")
//    @Query("SELECT menu FROM Menu menu order by menu.name")
    @Transactional(readOnly = true)
    //Collection<Menu> findMenu();
    Collection<Menu> findMenuByName(@Param("name") String name);
//    List<Menu> findMenu();



    @Query("SELECT menu FROM Menu menu WHERE menu.id =:id")
    @Transactional(readOnly = true)
    Menu findById(@Param("id") Integer id);

    void save(Menu menu);


}
