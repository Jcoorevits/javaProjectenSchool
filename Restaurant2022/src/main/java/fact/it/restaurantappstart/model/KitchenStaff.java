package fact.it.restaurantappstart.model;

import javax.persistence.*;
import java.util.Observable;


@Entity
public class KitchenStaff extends Staff {

    public KitchenStaff() {
    }

    public KitchenStaff(String name) {
        super(name);
    }


    //This is part of the Observer pattern
    public void update(){
        String message = "I am " + getName() + " and I start now with preparing " + EntranceCounter.getInstance().getNumber() + " appetizers!";
        System.out.println(message);
    }


}
