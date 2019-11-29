package dk.kea.goodcompany.grilld.takeawayOrder;

import dk.kea.goodcompany.grilld.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="order_items")
public class OrderItem extends BaseEntity {



  @Column(name= "price" )
  @NotNull
  private double price;

  @Column(name= "quantity" )
  @NotNull
  private int quantity;




  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

}
