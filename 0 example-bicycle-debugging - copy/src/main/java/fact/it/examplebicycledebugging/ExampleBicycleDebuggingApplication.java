package fact.it.examplebicycledebugging;


import fact.it.examplebicycledebugging.model.Bicycle;
import fact.it.examplebicycledebugging.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExampleBicycleDebuggingApplication {

    public static void main(String[] args) {

        SpringApplication.run(ExampleBicycleDebuggingApplication.class, args);
        // write code starting after this line
        Bicycle myBicycle = new Bicycle();
        myBicycle.setType("women's bicycle large");
        myBicycle.setYear(2016);
        myBicycle.setRentalPrice(4.5);

        System.out.println("You created a Bicycle-object with the following values:");
        System.out.println("The type of your bicycle is: " + myBicycle.getType());
        System.out.println("The year of your bicycle is: " + myBicycle.getYear());
        System.out.println("The rental price of your bicycle is: " + myBicycle.getRentalPrice());

        Bicycle myBicycle2 = new Bicycle( 2011,"small bicycle");

        myBicycle.increasePrice();
        System.out.println("After increasing the price, the rental price is now: " + myBicycle.getRentalPrice());
        System.out.println("And the price per year is: " + myBicycle.getPricePerYear());

        Student student = new Student("r0843822", "Jeremy", "Coorevits");

        student.setForeigner(true);

        System.out.println("Student data:");
        System.out.println("Full name: " + student.getFullName());
        System.out.println("Email: " + student.getEmailAddress());


        System.exit(0);
    }

}
