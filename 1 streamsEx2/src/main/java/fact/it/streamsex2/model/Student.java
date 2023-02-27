package fact.it.streamsex2.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String firstName,lastName;
    private int age;
    private List<Course> courses = new ArrayList<>();

    public Student() {
    }

    public Student(String firstName, String lastName, int age, List<Course> courses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.courses = courses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
