package fact.it.examplebicycledebugging.model;

public class Bicycle {
    private String type;
    private int year;
    private double rentalPrice;

    public Bicycle() {
        type= "not defined";
    }

    public Bicycle(int year, String type) {
        this.type = type;
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public int getYear() {
        return year;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public void increasePrice() {
        rentalPrice += 0.5;
    }

    public void increasePrice (double increase) {
        rentalPrice += increase;
    }

    public double getPricePerYear() {
        double pricePerYear = rentalPrice * 12;
        if (year < 2014) {
            pricePerYear *= 0.95;
        }
        return pricePerYear;
    }


}
