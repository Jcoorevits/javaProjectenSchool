package fact.it.restaurantappstart.repositories;


import fact.it.restaurantappstart.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<Table, Long> {
}
