//This is part of the Strategy pattern
package fact.it.restaurantappstart.model;

import javax.persistence.*;


public interface PaymentStrategy {
    public abstract double getAppliedPrice(double currentPrice);
}
