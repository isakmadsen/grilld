package dk.kea.goodcompany.grilld.reservation;

import org.springframework.data.repository.Repository;

public interface ReservaitionRepo extends Repository<ReservationTable, Integer> {

    void save(ReservationTable reservationTable);

}
