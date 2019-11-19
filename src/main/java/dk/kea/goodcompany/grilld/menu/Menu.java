package dk.kea.goodcompany.grilld.menu;

import dk.kea.goodcompany.grilld.model.NamedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="menu")
public class Menu extends NamedEntity {

    @Column(name= "description"  )
    @NotNull
    private String description;
}
