package fact.it.restaurantappstart.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "tableorder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "orderdate")
    private LocalDate date;
    private boolean payed;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Waiter waiter;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Table table;

    //The CasCadeType here is necesarry or else the order Items would not be made.
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @Transient
    // made Transient because we are not going to store it in the database
    private PaymentStrategy paymentStrategy;

    public Order() {
        if(this.paymentStrategy == null){
            NormalPayment normalPayment = new NormalPayment();
            this.paymentStrategy = normalPayment;
        }
    }

    public Order(LocalDate date, boolean payed, Waiter waiter, Table table) {
        //this is to set the Default paymentStrategy to NormalPayment
        NormalPayment normalPayment = new NormalPayment();
        this.paymentStrategy = normalPayment;

        this.date = date;
        this.payed = payed;
        this.waiter = waiter;
        this.table = table;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }



    //From here on it is part of the Strategy pattern
    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }


    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }


    public void addItem(Dish dish, int quantity){
        OrderItem orderItem = new OrderItem();
        orderItem.setDish(dish);
        orderItem.setQuantity(quantity);
        orderItem.setAppliedPrice(paymentStrategy.getAppliedPrice(dish.getCurrentPrice()));
        orderItem.setOrder(this);
        orderItems.add(orderItem);
    }


    public double getTotal(){
        double total = 0;
        for (OrderItem temp : orderItems){
            total += temp.getQuantity() * temp.getAppliedPrice();
        }
        return total;
    }
}
