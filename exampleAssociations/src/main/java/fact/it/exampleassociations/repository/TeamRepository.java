package fact.it.exampleassociations.repository;

import fact.it.exampleassociations.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
