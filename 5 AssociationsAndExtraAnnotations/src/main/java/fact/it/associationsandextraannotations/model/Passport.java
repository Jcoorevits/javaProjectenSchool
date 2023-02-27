package fact.it.associationsandextraannotations.model;

import javax.persistence.*;

@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String passportnbr;
    @OneToOne(mappedBy = "passport")
    private Person person;


    public Passport() {
    }

    public Passport(String passportnbr) {
        this.passportnbr = passportnbr;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassportnbr() {
        return passportnbr;
    }

    public void setPassportnbr(String passportnbr) {
        this.passportnbr = passportnbr;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
