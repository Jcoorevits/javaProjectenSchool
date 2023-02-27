//This is part of the Decorator pattern
package fact.it.restaurantappstart.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class ExtraTask extends Staff{
    private Staff staff;

    public ExtraTask() {
    }

    public ExtraTask(Staff staff) {
        this.staff = staff;
    }

    public ExtraTask(String name, Staff staff) {
        super(name);
        this.staff = staff;
    }

    public void update(){
        staff.update();
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
