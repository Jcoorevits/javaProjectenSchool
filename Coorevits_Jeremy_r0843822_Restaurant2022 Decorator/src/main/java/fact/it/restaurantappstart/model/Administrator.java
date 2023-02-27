package fact.it.restaurantappstart.model;

public class Administrator extends ExtraTask {


    @Override
    public void update() {
        super.update();
        System.out.println(String.format("Next, I register the %s customers in the customer file.", EntranceCounter.getInstance().getNumber()));

    }
}
