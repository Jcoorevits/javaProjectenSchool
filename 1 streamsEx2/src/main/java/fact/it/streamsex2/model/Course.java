package fact.it.streamsex2.model;

public class Course {
    private String name;
    private int studyPoints;

    public Course() {
    }

    public Course(String name, int studyPoints) {
        this.name = name;
        this.studyPoints = studyPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudyPoints() {
        return studyPoints;
    }

    public void setStudyPoints(int studyPoints) {
        this.studyPoints = studyPoints;
    }
}
