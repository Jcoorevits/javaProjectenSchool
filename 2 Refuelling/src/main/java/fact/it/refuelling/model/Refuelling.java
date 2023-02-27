package fact.it.refuelling.model;

import java.text.DecimalFormat;

public class Refuelling {
    int id, previousMileage, currentMileage;
    double amountInLitres;

    public Refuelling(int id, int previousMileage, int currentMileage, double amountInLitres) {
        this.id = id;
        this.previousMileage = previousMileage;
        this.currentMileage = currentMileage;
        this.amountInLitres = amountInLitres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPreviousMileage() {
        return previousMileage;
    }

    public void setPreviousMileage(int previousMileage) {
        this.previousMileage = previousMileage;
    }

    public int getCurrentMileage() {
        return currentMileage;
    }

    public void setCurrentMileage(int currentMileage) {
        this.currentMileage = currentMileage;
    }

    public double getAmountInLitres() {
        return amountInLitres;
    }

    public void setAmountInLitres(double amountInLitres) {
        this.amountInLitres = amountInLitres;
    }

    public double getFuelConsumption() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        double value = (this.amountInLitres / (this.currentMileage - this.previousMileage)) * 100;
        value = Double.parseDouble(decimalFormat.format(value));
        return value;
    }
}
