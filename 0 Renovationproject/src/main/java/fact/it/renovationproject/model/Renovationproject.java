package fact.it.renovationproject.model;

public class Renovationproject {
    private double length, width, height;
    private int numberOfLayers;
    private boolean ceilingIncluded;

    public Renovationproject(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getNumberOfLayers() {
        return numberOfLayers;
    }

    public void setNumberOfLayers(int numberOfLayers) {
        this.numberOfLayers = numberOfLayers;
    }

    public boolean isCeilingIncluded() {
        return ceilingIncluded;
    }

    public void setCeilingIncluded(boolean ceilingIncluded) {
        this.ceilingIncluded = ceilingIncluded;
    }
    public double getAmountOfPaintInLitres(){
        double area = 2 * (length + width) * height;
        double ceiling = length * width;
        if (isCeilingIncluded()){
            return  (area + ceiling) / 10 *  numberOfLayers;
        }
        return (2 * (length + width) * height) / 10 * numberOfLayers;
    }
}
