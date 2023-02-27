package fact.it.oefeningassociations.repository;

import fact.it.oefeningassociations.model.Jogger;
import fact.it.oefeningassociations.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoggerRepository extends JpaRepository<Jogger, Long> {
}
