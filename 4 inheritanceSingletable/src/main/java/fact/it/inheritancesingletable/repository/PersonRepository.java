package fact.it.inheritancesingletable.repository;

import fact.it.inheritancesingletable.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
