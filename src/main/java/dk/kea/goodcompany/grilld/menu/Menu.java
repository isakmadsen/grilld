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

    @Column(name = "price")
    @NotNull
    private Double price;

    @Column(name = "category")
    @NotNull
    private String category;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
