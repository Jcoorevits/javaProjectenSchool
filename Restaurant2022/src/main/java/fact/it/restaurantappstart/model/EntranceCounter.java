// This is part of the Singleton pattern
// also gets used in Observer pattern
package fact.it.restaurantappstart.model;

import java.util.Observable;

public final class EntranceCounter extends Subject {
    private int number;
    private static EntranceCounter entranceCounter;

    public EntranceCounter() {
    }

    public static EntranceCounter getInstance(){
        if(entranceCounter == null){
            entranceCounter = new EntranceCounter();
        }
        return entranceCounter;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
        //this is to notify all observers (Staff, Kitchen Staff & Waiters)
        notifyObservers();
    }

}
