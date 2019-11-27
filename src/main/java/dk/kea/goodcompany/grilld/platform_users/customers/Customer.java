package dk.kea.goodcompany.grilld.platform_users.customers;

import dk.kea.goodcompany.grilld.model.Person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "customers")
public class Customer extends Person {

    @Column(name = "phone_number")
    @NotEmpty
    private int phoneNumber;

    @Column(name = "username")
    @NotEmpty
    private String username;

    @Column(name = "password")
    @NotEmpty
    private String password;

    public boolean isNew() {
        return getId() == null;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "phoneNumber=" + phoneNumber +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

