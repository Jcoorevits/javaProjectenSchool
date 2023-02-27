package fact.it.restaurantappstart.model;


public final class EntranceCounter extends Subject {

    private static EntranceCounter entranceCounter;


    public int number;

    public EntranceCounter() {
        System.out.println("A singleton object is created.");
    }

    public static EntranceCounter getInstance() {
        if (entranceCounter == null) {
            entranceCounter = new EntranceCounter();
        }
        return entranceCounter;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
        notifyObserver();
    }
}
