package fact.it.exampleassociations.repository;

import fact.it.exampleassociations.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
