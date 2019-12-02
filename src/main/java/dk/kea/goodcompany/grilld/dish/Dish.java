package dk.kea.goodcompany.grilld.dish;

import dk.kea.goodcompany.grilld.model.NamedEntity;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Entity
@Table(name = "dish")
public class Dish extends NamedEntity {

    @Column(name = "description")
    @NotEmpty
    private String description;

    @Column(name = "price")
    @NotNull
    private Double price;

    @Column(name = "category")
    @NotEmpty
    private String category;

    @Column(name = "type")
    @NotEmpty
    private String type;

    @Column(name = "quantity")
    @NotNull
    private Integer quantity;


    public Dish() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


}
