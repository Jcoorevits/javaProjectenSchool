package fact.it.restaurantappstart.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "restaurant_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "orderdate")
    private LocalDate date;
    @Transient
    private PaymentStrategy paymentStrategy;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItemList = new ArrayList<>();
    private boolean payed;
    @ManyToOne
    private Waiter waiter;
    @ManyToOne
    private Table table;


    public Order() {
        if (this.paymentStrategy == null) {
            NormalPayment normalPayment = new NormalPayment();
            this.paymentStrategy = normalPayment;
        }

    }

    public Order(LocalDate date, boolean payed, Waiter waiter, Table table) {
        NormalPayment normalPayment = new NormalPayment();
        this.date = date;
        this.paymentStrategy = normalPayment;
        this.payed = payed;
        this.waiter = waiter;
        this.table = table;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public List<OrderItem> getOrderItems() {
        return orderItemList;
    }

    public void setOrderItems(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public void addItem(Dish dish, int quantity) {
        OrderItem orderItem = new OrderItem();
        orderItem.setDish(dish);
        orderItem.setQuantity(quantity);
        orderItem.setOrder(this);
        orderItem.setAppliedPrice(paymentStrategy.getAppliedPrice(dish.getCurrentPrice()));
        this.orderItemList.add(orderItem);
    }

    public double getTotal() {
        double total = 0;
        for (OrderItem item : orderItemList) {
            total += item.getQuantity() * item.getAppliedPrice();
        }
        return total;
    }
}
