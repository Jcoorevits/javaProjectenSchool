// This is part of the Observer pattern
package fact.it.restaurantappstart.model;

import java.util.ArrayList;
import java.util.List;
// https://www.programmergirl.com/observer-design-pattern-java/
// USEFULL LINK!!!!!
public abstract class Subject {
    private List<Staff> observers = new ArrayList<>();

    public void attachObserver(Staff observer){
        this.observers.add(observer);
    }

    public void detachObserver(Staff observer){
        if(this.observers.contains(observer)){
            this.observers.remove(observer);
        }
    }

    public void notifyObservers(){
        for(Staff o: observers){
            o.update();
        }
    }

    public List<Staff> getObservers() {
        return observers;
    }

    public void setObservers(List<Staff> observers) {
        this.observers = observers;
    }
}
