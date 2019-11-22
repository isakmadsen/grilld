package dk.kea.goodcompany.grilld.reservation;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class OrderTable {

    private int id, amountOfPersons;
    private String telephone;
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime booked_on;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
