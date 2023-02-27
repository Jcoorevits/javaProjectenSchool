package fact.it.restaurantappstart.repositories;

import fact.it.restaurantappstart.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {
}
