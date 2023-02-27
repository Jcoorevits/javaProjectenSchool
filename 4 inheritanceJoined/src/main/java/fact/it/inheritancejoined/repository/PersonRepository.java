package fact.it.inheritancejoined.repository;

import fact.it.inheritancejoined.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
