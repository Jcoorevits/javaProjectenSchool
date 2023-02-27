package fact.it.oefeningassociations.model;

import javax.persistence.*;

@Entity
public class Jogger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int bibNumber, yearOfBirth;
    private String name, location;
    @Embedded
    private Time time;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @ManyToOne
    private Club club;

    public Jogger() {

    }

    public Jogger(int bibNumber, String name, int yearOfBirth, String location, Gender gender) {
        this.bibNumber = bibNumber;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.location = location;
        this.gender = gender;
    }
    public Jogger(int bibNumber, int yearOfBirth, String name, String location, Time time, Gender gender, Club club) {
        this.bibNumber = bibNumber;
        this.yearOfBirth = yearOfBirth;
        this.name = name;
        this.location = location;
        this.time = time;
        this.gender = gender;
        this.club = club;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getBibNumber() {
        return bibNumber;
    }

    public void setBibNumber(int bibNumber) {
        this.bibNumber = bibNumber;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
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

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
