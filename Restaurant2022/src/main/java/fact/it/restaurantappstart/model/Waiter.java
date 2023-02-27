package fact.it.restaurantappstart.model;

import javax.persistence.*;

@Entity
public class Waiter extends Staff{

    public Waiter() {
    }

    public Waiter(String name) {
        super(name);
    }

    //This is part of the Observer pattern
    public void update(){
        String message = "I am " + getName() + " and I start preparing the table for " + EntranceCounter.getInstance().getNumber() + " customers.";
        System.out.println(message);
    }
}
