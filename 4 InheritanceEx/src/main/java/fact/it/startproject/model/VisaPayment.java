package fact.it.startproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VisaPayment extends ElectronicPayment {

    private String cardNumber, expirationDate;

    public VisaPayment() {
    }

    public VisaPayment(String beneficiary, String currency, double amount, String clientName, String clientAccount, String cardNumber, String expirationDate) {
        super(beneficiary, currency, amount, clientName, clientAccount);
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
