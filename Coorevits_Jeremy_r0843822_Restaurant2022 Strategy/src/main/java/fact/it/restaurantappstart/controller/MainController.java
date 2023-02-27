package fact.it.restaurantappstart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import fact.it.restaurantappstart.model.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Controller
public class MainController {


    @RequestMapping("/start")
    public String starten(Model model, HttpServletRequest request) {
        String feedbacktekst = "";
        if (request.getParameter("singletontest") != null) {
            System.out.println("####################################################################");
            EntranceCounter it1 = EntranceCounter.getInstance();
            EntranceCounter it2 = EntranceCounter.getInstance();

            if (it1 == it2) {
                System.out.println("The 2 singleton variables refer to the same object.");
            } else {
                System.out.println("The Singleton-pattern is not correct implemented");
            }
            System.out.println("####################################################################");
            feedbacktekst = "The singletontest has been executed. Check the output window of IntelliJ to see the result";

        }
        if (request.getParameter("observertest") != null) {
            EntranceCounter klantTeller = EntranceCounter.getInstance();

            //a few staff members
            Waiter jan = new Waiter("Jan");
            Waiter piet = new Waiter("Piet");
            KitchenStaff serge = new KitchenStaff("Serge");
            KitchenStaff jeroen = new KitchenStaff("Jeroen");

            //we attach the staffmembers as observer to the entranceCounter
            klantTeller.attachObserver(jan);
            klantTeller.attachObserver(piet);
            klantTeller.attachObserver(serge);
            klantTeller.attachObserver(jeroen);


            System.out.println("####################################################################");
            System.out.println("After attaching the observers, 5 customers enter the restaurant (the number of entrance counter is set at 5)");
            //5 clients enter the restaurant
            klantTeller.setNumber(5);
            //empty line
            System.out.println();
            //we detach some observers
            klantTeller.detachObserver(piet);
            klantTeller.detachObserver(serge);

            System.out.println("After detaching Piet and Serge, 3 customers enter the restaurant (the number of the entrance counter is set tot 3)");
            //3 clients enter the restaurant
            klantTeller.setNumber(3);
            System.out.println("####################################################################");
            feedbacktekst = "The observer test has been executed. Check the output window of IntelliJ to see the result";

        }
        if (request.getParameter("strategytest") != null) {
            System.out.println("####################################################################");
            //Create payment strategies
            HappyHourPayment happyHourPayment = new HappyHourPayment();
            NormalPayment normalPayment = new NormalPayment();
            //create dishes
            Dish videe = new Dish();
            videe.setName("Fish and Chips");
            videe.setCurrentPrice(15.0);
            Dish croque = new Dish();
            croque.setName("Cottage Pie");
            croque.setCurrentPrice(10.0);


            //make order with orderitems
            Order order = new Order();
            //NORMAAL
            order.setPaymentStrategy(normalPayment);
            order.setDate(LocalDate.now());
            order.addItem(videe, 2);
            order.addItem(croque, 2);
            System.out.println("The normal payment strategy is implemented: ");
            for( OrderItem i: order.getOrderItems()){
                System.out.println(i.getQuantity() + " " + i.getDish().getName() + " price " + i.getAppliedPrice() );
            }


            //HAPPYHOUR
            order.setPaymentStrategy(happyHourPayment);
            order.addItem(videe, 2);
            order.addItem(croque, 2);
            System.out.println("The happy-hour payment strategy is implemented: ");
            for (int i=2;i<4;i++){
                System.out.println(order.getOrderItems().get(i).getQuantity() + " " + order.getOrderItems().get(i).getDish().getName() + " price " + order.getOrderItems().get(i).getAppliedPrice() );
            }

            //NORMAAL
            order.setPaymentStrategy(normalPayment);
            order.addItem(videe, 2);
            order.addItem(croque, 2);
            System.out.println("The normal payment strategy is implemented again: ");
            for (int i=4;i<6;i++){
                System.out.println(order.getOrderItems().get(i).getQuantity() + " " + order.getOrderItems().get(i).getDish().getName() + " price " + order.getOrderItems().get(i).getAppliedPrice() );
            }
            System.out.println("Order balance " + order.getTotal() + " euro");
            System.out.println("####################################################################");
            feedbacktekst = "strategytest has been executed. Check the output window of IntelliJ to see the result";
        }
        if (request.getParameter("decoratortest") != null) {
//            EntranceCounter entranceCounter = EntranceCounter.getInstance();
//            entranceCounter.getObservers().clear();
//            // we create a waiter and add him as observer
//            System.out.println("####################################################################");
//            Waiter manu = new Waiter("Manu");
//            entranceCounter.attachObserver(manu);
//            entranceCounter.setNumber(7);
//            // we detach manu and we add him as cleaningstaff so he can still react to the entrance counter but he can also clean
//            System.out.println("####################################################################");
//            entranceCounter.detachObserver(manu);
//            entranceCounter.setNumber(10);
//            CleaningStaff poetsPersoon = new CleaningStaff();
//            poetsPersoon.setStaff(manu);
//            poetsPersoon.clean();
//            // Manu also has to do the administration when a client enters the restaurant
//            System.out.println("####################################################################");
//            Administrator administrator = new Administrator();
//            administrator.setStaff(manu);
//            entranceCounter.attachObserver(administrator);
//            entranceCounter.setNumber(5);
//            System.out.println("####################################################################");
//            feedbacktekst = "decoratortest has been executed. Check the output window of IntelliJ to see the result";

        }
        model.addAttribute("tekst", feedbacktekst);
        return "index";
    }
}
