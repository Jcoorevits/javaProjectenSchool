package fact.it.inheritancesingletable.model;

import javax.persistence.Entity;


@Entity
public class Employee extends Person {
    private double salary;

    public Employee() {
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
