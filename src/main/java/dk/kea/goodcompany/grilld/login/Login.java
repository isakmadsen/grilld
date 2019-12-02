package dk.kea.goodcompany.grilld.login;

import dk.kea.goodcompany.grilld.model.NamedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "login")


public class Login extends NamedEntity {

    @Column(name = "type")
    @NotNull
    private String type_tlf;

    @Column(name = "password")
    @NotNull
    private String password;

    public Login() {
    }

    public String getType_tlf() {
        return type_tlf;
    }

    public void setType_tlf(String type_telf) {
        this.type_tlf = type_telf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
