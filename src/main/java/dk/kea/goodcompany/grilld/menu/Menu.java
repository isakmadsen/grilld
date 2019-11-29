package dk.kea.goodcompany.grilld.menu;

import dk.kea.goodcompany.grilld.model.NamedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="menu")
public class Menu extends NamedEntity {

    @Column(name= "description"  )
    @NotNull
    private String description;

    @Column(name = "price")
    @NotNull
    private BigDecimal price;

    @Column(name = "category")
    @NotNull
    private String category;

    @Column(name= "type")
    @NotNull
    private String type;

    @Column(name = "quantity")
    @NotNull
    private Integer quantity;





    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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

    public void setType(String type) { this.type = type; }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Menu product = (Menu) o;

        return product.getId().equals(product.getId());
    }


}
