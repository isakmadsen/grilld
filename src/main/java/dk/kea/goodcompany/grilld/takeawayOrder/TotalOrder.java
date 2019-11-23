package dk.kea.goodcompany.grilld.takeawayOrder;

import dk.kea.goodcompany.grilld.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name="total_orders")
public class TotalOrder extends BaseEntity {

  @Column(name= "total_price" )
  @NotNull
  private double totalPrice;

  @Column(name = "date")
  @NotNull
  private Date date;

  @Column(name = "customer_id")
  @NotNull
  private int customerId;

  public double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public int getCustomerId() {
    return customerId;
  }

  public void setCustomerId(int customerId) {
    this.customerId = customerId;
  }


}
