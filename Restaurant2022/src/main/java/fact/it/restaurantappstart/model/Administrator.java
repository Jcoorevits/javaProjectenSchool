//This is part of the Decorator pattern
package fact.it.restaurantappstart.model;

public class Administrator extends ExtraTask{

    public void update(){
        super.update();
        String message = "Next, I register the " + EntranceCounter.getInstance().getNumber() +" customers in the customer file.";
        System.out.println(message);
    }
}
