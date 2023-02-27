package fact.it.oefeningassociations.repository;

import fact.it.oefeningassociations.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, Long> {
}
