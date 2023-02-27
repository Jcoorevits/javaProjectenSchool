//Jeremy Coorevits r0843822

package fact.it.projectthemepark.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Staff extends Person {
    private LocalDate startDate;
    private boolean student;
    private ThemePark employedAt;

    public Staff(String firstName, String surName) {
        super(firstName, surName);
        this.startDate = LocalDate.now();
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public boolean isStudent() {
        return student;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public ThemePark getEmployedAt() {
        return employedAt;
    }

    public void setEmployedAt(ThemePark employedAt) {
        this.employedAt = employedAt;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if (student){
            return String.format("Staff member %s (working student) is employed since %s", super.toString(), formatter.format(getStartDate()));
        }else {
            return String.format("Staff member %s is employed since %s", super.toString(),  formatter.format(getStartDate()));
        }
    }
}
