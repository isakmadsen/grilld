package dk.kea.goodcompany.grilld.reservation;

import org.springframework.data.repository.Repository;

public interface ReservaitionRepo extends Repository<OrderTable, Integer> {

    void save(OrderTable orderTable);

}
