package fact.it.inheritancetableperclass.model;

import javax.persistence.Entity;


@Entity
public class Executive extends Employee {
    private double bonus;

    public Executive() {
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
