package fact.it.restaurantappstart.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "restaurant_table")
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String code;

    public Table() {
    }

    public Table(String code) {
        this.code = code;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
