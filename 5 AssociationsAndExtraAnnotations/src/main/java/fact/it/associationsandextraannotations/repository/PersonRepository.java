package fact.it.associationsandextraannotations.repository;

import fact.it.associationsandextraannotations.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
