package fact.it.restaurantappstart.repositories;


import fact.it.restaurantappstart.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findOrdersByTableCode(String code);

    List<Order> findOrdersByDateBefore(LocalDate date);

//    List<Order> findOrdersByTotalLessThan(double amount);
}
