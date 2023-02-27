//Jeremy Coorevits r0843822

package fact.it.projectthemepark.model;

public class Person {
    private String firstName, surName;

    public Person() {
    }

    public Person(String firstName, String surName) {
        this.firstName = firstName;
        this.surName = surName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public String toString() {
        return this.surName.toUpperCase() + " " + this.firstName;
    }
}
