package fact.it.restaurantappstart.model;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public abstract class Subject {
    @OneToMany(mappedBy = "subject")
    private List<Staff> observers;

    public Subject(){
        observers = new ArrayList<Staff>();
    }
    public void attachObserver(Staff o) {
        observers.add(o);
    }

    public void detachObserver(Staff o) {
        // Get the index of the observer to delete
        int observerIndex = observers.indexOf(o);
        // Print out message (Have to increment index to match)
        // Removes observer from the ArrayList
        observers.remove(observerIndex);
    }

    public void notifyObserver() {
        // Cycle through all observers and notifies them of
        // price changes
        for (Staff observer : observers) {
            observer.update();
        }
    }

    public List<Staff> getObservers() {
        return observers;
    }

    public void setObservers(List<Staff> staffList) {
        this.observers = staffList;
    }
}
