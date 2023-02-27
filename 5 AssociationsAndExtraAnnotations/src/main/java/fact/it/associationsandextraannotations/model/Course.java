package fact.it.associationsandextraannotations.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @ManyToMany(mappedBy = "courses")
    private List<Person> students = new ArrayList<>();


    public Course() {
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

    public List<Person> getStuednts() {
        return students;
    }

    public void setStuednts(ArrayList<Person> stuednts) {
        this.students = stuednts;
    }
}
