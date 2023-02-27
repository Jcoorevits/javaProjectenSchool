package fact.it.startproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AmexPayment extends ElectronicPayment {
    private int pinCode;

    public AmexPayment() {
    }

    public AmexPayment(String beneficiary, String currency, double amount, String clientName, String clientAccount, int pinCode) {
        super(beneficiary, currency, amount, clientName, clientAccount);
        this.pinCode = pinCode;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }
}
