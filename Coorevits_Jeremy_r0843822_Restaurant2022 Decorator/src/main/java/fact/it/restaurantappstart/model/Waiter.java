package fact.it.restaurantappstart.model;

import javax.persistence.Entity;

@Entity
public class Waiter extends Staff {
    public Waiter() {
    }

    public Waiter(String name) {
        super(name);
    }

    @Override
    public void update() {
        System.out.println(String.format("I am %s and I start preparing the table for %s customers.", getName(), EntranceCounter.getInstance().getNumber()));
    }
}
