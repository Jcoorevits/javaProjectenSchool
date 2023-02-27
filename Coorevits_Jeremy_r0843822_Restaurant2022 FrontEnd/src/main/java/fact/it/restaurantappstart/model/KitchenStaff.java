package fact.it.restaurantappstart.model;

import javax.persistence.Entity;

@Entity
public class KitchenStaff extends Staff {

    public KitchenStaff() {
    }

    public KitchenStaff(String name) {
        super(name);
    }

    @Override
    public void update() {
        System.out.println(String.format("I am %s and I start now with preparing %s appetizers!", getName(), EntranceCounter.getInstance().getNumber()));

    }
}
