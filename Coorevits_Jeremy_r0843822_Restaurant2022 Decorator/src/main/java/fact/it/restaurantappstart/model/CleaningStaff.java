package fact.it.restaurantappstart.model;

public class CleaningStaff extends ExtraTask{
    public void clean() {
        System.out.println(String.format("I am %s and now I start also with cleaning.", staff.getName()));
    }
}
