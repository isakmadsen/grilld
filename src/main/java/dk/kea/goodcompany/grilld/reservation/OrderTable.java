package dk.kea.goodcompany.grilld.reservation;

import dk.kea.goodcompany.grilld.model.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
@Entity
@Table(name="reservation")
public class OrderTable extends BaseEntity {


    @Column(name="amountOfPersons")
    @NotNull
    private int amountOfPersons;
    @Column(name="telephone")
    @NotNull
    private String telephone;
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    @Column(name="booked_on")
    @NotNull
    private LocalDateTime booked_on;


    public OrderTable() {
    }

    public int getAmountOfPersons() {
        return amountOfPersons;
    }

    public void setAmountOfPersons(int amountOfPersons) {
        this.amountOfPersons = amountOfPersons;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public LocalDateTime getBooked_on() {
        return booked_on;
    }

    public void setBooked_on(LocalDateTime booked_on) {
        this.booked_on = booked_on;
    }
}
