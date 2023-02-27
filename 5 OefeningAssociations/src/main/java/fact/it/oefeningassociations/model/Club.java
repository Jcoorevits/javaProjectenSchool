package fact.it.oefeningassociations.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name, location;
    private double memberfee;
    @OneToMany(mappedBy = "club")
    private List<Jogger> memberList;
    @OneToMany(mappedBy = "club")
    private List<Event> eventList;

    public Club() {
    }
    public Club(String name, String location, double memberfee) {

        this.name = name;
        this.location = location;
        this.memberfee = memberfee;
    }

    public Club(String name) {
        this.name = name;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getMemberfee() {
        return memberfee;
    }

    public void setMemberfee(double memberfee) {
        this.memberfee = memberfee;
    }

    public List<Jogger> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Jogger> memberList) {
        this.memberList = memberList;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    public String toString() {
        return name;
    }
}
