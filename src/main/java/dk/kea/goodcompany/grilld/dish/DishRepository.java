package dk.kea.goodcompany.grilld.dish;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface DishRepository extends Repository<Dish, Integer> {



    @Query("SELECT DISTINCT dish FROM Dish dish WHERE dish.name LIKE :name%")
    @Transactional(readOnly = true)
    Collection<Dish> findDishByName(@Param("name") String name);


    Collection<Dish> findDishByType(String type);




    @Query("SELECT dish FROM Dish dish WHERE dish.id =:id")
    @Transactional(readOnly = true)
    Dish findById(@Param("id") Integer id);

    void save(Dish dish);



}
