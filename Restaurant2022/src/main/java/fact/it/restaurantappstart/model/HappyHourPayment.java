//This is part of the Strategy pattern
package fact.it.restaurantappstart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class HappyHourPayment implements PaymentStrategy{

    public double getAppliedPrice(double currentPrice) {
        return 0.8 * currentPrice;
    }


}
