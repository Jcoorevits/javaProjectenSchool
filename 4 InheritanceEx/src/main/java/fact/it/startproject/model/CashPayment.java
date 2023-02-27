package fact.it.startproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CashPayment extends Payment {
    private String name;

    public CashPayment() {
    }

    public CashPayment(String beneficiary, String currency, double amount, String name) {
        super(beneficiary, currency, amount);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
