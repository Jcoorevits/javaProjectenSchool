package fact.it.restaurantappstart.model;

import javax.persistence.*;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
public abstract class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    //in order to query by dtype (Waiter of KitchenStaff)
    @Column(insertable = false, updatable = false)
    private String dtype;

    public Staff() {
    }

    public Staff(String name) {

        this.name = name;
    }

    public String getDtype() {
        return dtype;
    }

    

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //This is part of the Observer pattern
    public abstract void update();
}
