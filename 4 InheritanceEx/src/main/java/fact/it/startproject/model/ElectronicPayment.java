package fact.it.startproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ElectronicPayment extends Payment {

    private String clientName, clientAccount;

    public ElectronicPayment() {
    }

    public ElectronicPayment(String beneficiary, String currency, double amount, String clientName, String clientAccount) {
        super(beneficiary, currency, amount);
        this.clientName = clientName;
        this.clientAccount = clientAccount;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAccount() {
        return clientAccount;
    }

    public void setClientAccount(String clientAccount) {
        this.clientAccount = clientAccount;
    }
}
