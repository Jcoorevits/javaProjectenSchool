package fact.it.restaurantappstart.repository;

import fact.it.restaurantappstart.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

    @Query("select w from Waiter w")
    List<Staff> listOfAllWaiters();
//
//    @Query("select b from Staff b WHERE b.dtype='KitchenStaff'")
//    List<Staff> findAllByKitchenStaff();


}
