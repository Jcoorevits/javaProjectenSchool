package fact.it.associationsandextraannotations.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @ManyToMany
    private List<Course> courses = new ArrayList<>();
    @OneToMany(cascade = {CascadeType.ALL})

    private List<Phone> phonenbrs = new ArrayList<>();

    @OneToOne(cascade = {CascadeType.ALL})
    private Passport passport;

    @ManyToOne
    private Team team;


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

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public List<Phone> getPhonenbrs() {
        return phonenbrs;
    }

    public void setPhonenbrs(ArrayList<Phone> phonenbrs) {
        this.phonenbrs = phonenbrs;
    }

    public void addPhonenbr(String type, String number) {
        Phone phone = new Phone();
        phone.setType(type);
        phone.setNumber(number);
        this.phonenbrs.add(phone);
    }


    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return name;
    }
}
