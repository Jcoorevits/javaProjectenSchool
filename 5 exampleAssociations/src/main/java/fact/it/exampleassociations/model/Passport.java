package fact.it.exampleassociations.model;

import javax.persistence.*;

@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(mappedBy= "passport")
    private Person person;
    private String passportnbr;

    public Passport() {
    }

    public Passport(String passportnbr) {
        this.passportnbr = passportnbr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public String getPassportnbr() {
        return passportnbr;
    }

    public void setPassportnbr(String passportnbr) {
        this.passportnbr = passportnbr;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
