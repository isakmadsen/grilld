package dk.kea.goodcompany.grilld.takeawayOrder;

import dk.kea.goodcompany.grilld.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="order_items")
public class OrderItem extends BaseEntity {

  @Column(name = "total_order_id")
  @NotNull
  private int totalOrderId;

  @Column(name = "item")
  @NotNull
  private String item;

  @Column(name= "price" )
  @NotNull
  private double price;

  @Column(name= "quantity" )
  @NotNull
  private int quantity;

  @Column(name = "customer_id")
  @NotNull
  private int customerId;

  public int getTotalOrderId() {
    return totalOrderId;
  }

  public void setTotalOrderId(int totalOrderId) {
    this.totalOrderId = totalOrderId;
  }

  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

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

  public int getCustomerId() {
    return customerId;
  }

  public void setCustomerId(int customerId) {
    this.customerId = customerId;
  }


}
