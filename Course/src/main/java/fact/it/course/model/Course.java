package fact.it.course.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Course {
    private String name, location;
    private LocalDate startDate;
    private int numberOfDays;
    private boolean weekly;

    public Course(String name) {
        this.name = name;
    }

    public Course(String name, int numberOfDays) {
        this.name = name;
        this.numberOfDays = numberOfDays;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public boolean isWeekly() {
        return weekly;
    }

    public void setWeekly(boolean weekly) {
        this.weekly = weekly;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if (isWeekly()) {
            return String.format("This is a weekly course starting on %s running for %s weeks.", formatter.format(getStartDate()), getNumberOfDays());
        } else {
            return String.format("This course starts on %s and runs for %s days.", formatter.format(getStartDate()), getNumberOfDays());
        }
    }
}
