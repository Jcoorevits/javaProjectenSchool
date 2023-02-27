package fact.it.oefeningassociations.repository;

import fact.it.oefeningassociations.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
