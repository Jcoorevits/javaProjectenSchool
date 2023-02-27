package fact.it.streamsex2.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class School {
    private List<Course> courseList = new ArrayList<>();
    private List<Student> studentList = new ArrayList<>();

    public School() {
        Course programmerI = new Course("Programmer I", 5);
        Course sqlDatabases = new Course("SQL Databases", 3);
        Course linux = new Course("Linux", 8);
        courseList = Arrays.asList(programmerI, sqlDatabases, linux);
        studentList = Arrays.asList(
                new Student("Amber", "Akkermans", 21, Arrays.asList(programmerI, sqlDatabases, linux)),
                new Student("Bert", "Bergmans", 18, Arrays.asList(linux)),
                new Student("Carly", "Coopman", 25, Arrays.asList(programmerI, linux)),
                new Student("Dirk", "Dieltjens", 19, Arrays.asList(programmerI, sqlDatabases)),
                new Student("Erik", "Eyken", 17, Arrays.asList(programmerI, sqlDatabases, linux)),
                new Student("Fré", "Frederickx", 23, Arrays.asList(linux)),
                new Student("Gust", "Grevers", 20, Arrays.asList(sqlDatabases, linux)),
                new Student("Hans", "Hooimans", 22, Arrays.asList(programmerI, sqlDatabases, linux)),
                new Student("Isis", "Ilsen", 19, Arrays.asList(sqlDatabases, linux)),
                new Student("Joris", "Jonkers", 25, Arrays.asList(programmerI, linux)),
                new Student("Kim", "Keuppens", 31, Arrays.asList(programmerI)),
                new Student("Laura", "Liekens", 21, Arrays.asList(sqlDatabases)),
                new Student("Merel", "Meulemans", 18, Arrays.asList(programmerI, sqlDatabases, linux)),
                new Student("Nele", "Nauwelaers", 19, Arrays.asList(linux)),
                new Student("Oscar", "Oppens", 18, Arrays.asList(programmerI, sqlDatabases, linux)),
                new Student("Pieter", "Peters", 21, Arrays.asList(programmerI, sqlDatabases, linux)),
                new Student("Quinten", "Qwards", 22, Arrays.asList(sqlDatabases, linux)),
                new Student("Rik", "Rubens", 20, Arrays.asList(programmerI, sqlDatabases)),
                new Student("Stef", "Stekker", 20, Arrays.asList(programmerI)),
                new Student("Toon", "Timmers", 21, Arrays.asList(programmerI, linux)),
                new Student("Ursula", "Uyterhoeven", 22, Arrays.asList(programmerI, sqlDatabases, linux)),
                new Student("Viktor", "Van der Veken", 20, Arrays.asList(programmerI, linux)),
                new Student("Wim", "Winkers", 21, Arrays.asList(programmerI)),
                new Student("Xanty", "Xanders", 19, Arrays.asList(programmerI, sqlDatabases, linux)),
                new Student("Yael", "Ysebaert", 18, Arrays.asList(linux)),
                new Student("Zuster", "Zulma", 22, Arrays.asList(sqlDatabases, linux)));

    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    // returns List if STUDENTS!
    public List<Student> getFilteredList(String lname, String fname, int age, int numberOfCourses, String course) {
        Stream stream = studentList.stream().filter(l -> l.getLastName().toLowerCase().contains(lname) && l.getFirstName().toLowerCase().contains(fname) && l.getAge() > age && l.getCourses().size() > numberOfCourses).sorted((i, j) -> i.getFirstName().compareTo(j.getFirstName()));
        if (!course.equals("Choose a course")) {
            stream = getFilteredOnCourse(stream, course);
        }
        return stream.toList();
    }

    public Stream getFilteredOnCourse(Stream<Student> filteredList, String course) {
        return filteredList.filter(i -> i.getCourses().stream().filter(j -> j.getName().equals(course)).count() > 0);
    }
}