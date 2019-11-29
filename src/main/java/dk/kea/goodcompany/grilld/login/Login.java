package dk.kea.goodcompany.grilld.login;

import dk.kea.goodcompany.grilld.model.NamedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "login")
public class Login extends NamedEntity {

    @Column(name = "type")
    @NotEmpty
    private String type;

    @Column(name = "password")
    @NotEmpty
    private String password;

    @Column(name = "telephone")
    private String telephone;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
