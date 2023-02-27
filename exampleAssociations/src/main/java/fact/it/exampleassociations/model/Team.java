package fact.it.exampleassociations.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String assignment;
    private String number;
    @OneToMany(mappedBy="team")
    private List<Person> members = new ArrayList<>();

    public Team() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssignment() {
        return assignment;
    }

    public void setAssignment(String opdracht) {
        this.assignment = opdracht;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Person> getMembers() {
        return members;
    }

    public void setMembers(List<Person> members) {
        this.members = members;
    }

    public String toString() {
        return assignment + " ("+ number +")";
    }
}
