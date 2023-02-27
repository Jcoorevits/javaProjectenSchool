package fact.it.associationsandextraannotations.repository;

import fact.it.associationsandextraannotations.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
