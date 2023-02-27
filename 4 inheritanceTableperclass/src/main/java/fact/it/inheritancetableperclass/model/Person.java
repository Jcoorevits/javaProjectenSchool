package fact.it.inheritancetableperclass.model;

import javax.persistence.*;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String name;

    public Person() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
