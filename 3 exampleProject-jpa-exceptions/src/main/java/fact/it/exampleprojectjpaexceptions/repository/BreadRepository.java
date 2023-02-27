package fact.it.exampleprojectjpaexceptions.repository;


import fact.it.exampleprojectjpaexceptions.model.Bread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BreadRepository extends JpaRepository<Bread, Long> {
    List<Bread> findAllByNameStartsWith(String searchString);
    @Query("select b from Bread b order by b.price ASC")
    List<Bread> giveListOfAllBreadsOrderedByPrice();
   // List<Bread> findAllByOrderByPriceAsc();
    @Query("select b from Bread b where b.price in (select min(b.price) from Bread b)")
    List<Bread> findCheapestBreads();
    Optional<Bread> findBreadById(long id);
}
