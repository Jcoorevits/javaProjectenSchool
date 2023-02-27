package fact.it.restaurantappstart.model;

public interface PaymentStrategy {
    double getAppliedPrice(double currentPrice);
}
