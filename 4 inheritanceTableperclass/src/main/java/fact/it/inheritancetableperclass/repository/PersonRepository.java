package fact.it.inheritancetableperclass.repository;

import fact.it.inheritancetableperclass.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
