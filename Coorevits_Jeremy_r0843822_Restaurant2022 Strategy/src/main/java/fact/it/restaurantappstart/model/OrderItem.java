package fact.it.restaurantappstart.model;

import javax.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    public int quantity;
    public double appliedPrice;
    @ManyToOne(cascade = CascadeType.ALL)
    public Order order;
    @ManyToOne
    public Dish dish;

    public OrderItem() {
    }

    public OrderItem(int quantity, double appliedPrice, Order order, Dish dish) {
        this.quantity = quantity;
        this.appliedPrice = appliedPrice;
        this.order = order;
        this.dish = dish;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAppliedPrice() {
        return appliedPrice;
    }

    public void setAppliedPrice(double appliedPrice) {
        this.appliedPrice = appliedPrice;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
