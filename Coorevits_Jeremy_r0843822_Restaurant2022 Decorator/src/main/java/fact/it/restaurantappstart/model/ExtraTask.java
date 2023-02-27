package fact.it.restaurantappstart.model;

import javax.persistence.ManyToOne;

public abstract class ExtraTask extends Staff {

    @ManyToOne
    public Staff staff;

    @Override
    public void update() {
        staff.update();
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
