//This is part of the Decorator pattern
package fact.it.restaurantappstart.model;

public class CleaningStaff extends ExtraTask {



    public void clean(){
        String message = "I am " + super.getStaff().getName() + " and now I start also with cleaning.";
        System.out.println(message);
    }
}
