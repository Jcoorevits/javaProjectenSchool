package fact.it.restaurantappstart.repositories;


import fact.it.restaurantappstart.model.KitchenStaff;
import fact.it.restaurantappstart.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Long> {

    @Query("select w from Waiter w")
    List<Staff> listOfAllWaiters();
}
