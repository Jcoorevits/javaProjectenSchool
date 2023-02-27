package fact.it.restaurantappstart.controller;

import fact.it.restaurantappstart.model.*;
import fact.it.restaurantappstart.repository.DishRepository;
import fact.it.restaurantappstart.repository.OrderRepository;
import fact.it.restaurantappstart.repository.StaffRepository;
import fact.it.restaurantappstart.repository.TableRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

@Controller
public class DatabaseFillerController {
    private OrderRepository orderRepository;
    private StaffRepository staffRepository;
    private DishRepository dishRepository;
    private TableRepository tableRepository;

    public DatabaseFillerController(OrderRepository orderRepository, StaffRepository staffRepository, DishRepository dishRepository, TableRepository tableRepository) {
        this.orderRepository = orderRepository;
        this.staffRepository = staffRepository;
        this.dishRepository = dishRepository;
        this.tableRepository = tableRepository;
    }

    //used to change the value of the "generated data" button.
    private boolean filled = false;

    @RequestMapping("/")
    public String index(Model model){
        // Will get the attribute, if the data is filled the attribute will be true.
        model.addAttribute("filledData",this.filled);
        return "index";
    }

    @RequestMapping("/fillWithData")
    public String fillWithData(Model model, HttpServletRequest request){
        // Call the fillDatabase method only if false
        if(!this.filled){
            this.fillDatabase();
        }
//        model.addAttribute("response","The filling of the table was succesful");
        model.addAttribute("filledData",this.filled);

        // With redirect the page will no longer have the "FillData" parameter
        return "redirect:/";
    }

    // To fill the databse with data
    public void fillDatabase(){
        Dish dish1 = new Dish("Friet met stoofvlees",3.5);
        Dish dish2 = new Dish("Frikadellen met krieken",5.7);
        Dish dish3 = new Dish("Spaghetti Bolognaise", 6);
        Dish dish4 = new Dish("Lasagne",6.5);
        Dish dish5 = new Dish("kaviaar",37.5);

        Table table1 = new Table("A12");
        Table table2 = new Table("A13");
        Table table3 = new Table("A14");
        Table table4 = new Table("A15");
        Table table5 = new Table("A16");

        KitchenStaff kitchenStaff1 = new KitchenStaff("Jan");
        KitchenStaff kitchenStaff2 = new KitchenStaff("Jozef");
        KitchenStaff kitchenStaff3 = new KitchenStaff("Rick");
        KitchenStaff kitchenStaff4 = new KitchenStaff("Tom");
        KitchenStaff kitchenStaff5 = new KitchenStaff("Jef");

        Waiter waiter1 = new Waiter("Silke");
        Waiter waiter2 = new Waiter("Debora");
        Waiter waiter3 = new Waiter("Anja");
        Waiter waiter4 = new Waiter("Steffi");
        Waiter waiter5 = new Waiter("Simonne");

        Order order1 = new Order(LocalDate.of(2022,5,8),true,waiter1,table1);
        Order order2 = new Order(LocalDate.of(2022,9,27),false,waiter2,table2);
        Order order3 = new Order(LocalDate.of(2023,3,25),false,waiter3,table3);
        Order order4 = new Order(LocalDate.of(2022,11,3),false,waiter4,table4);
        Order order5 = new Order(LocalDate.of(2022,1,12),false,waiter5,table5);

        // to add items in the orders
        order1.addItem(dish1,2);
        order1.addItem(dish3,1);
        order2.addItem(dish2,2);
        order2.addItem(dish4,1);
        order2.addItem(dish3,4);
        order3.addItem(dish1,1);
        order3.addItem(dish5,2);
        order4.addItem(dish2,3);
        order4.addItem(dish1,1);
        order5.addItem(dish4,2);

        this.dishRepository.saveAll(List.of(
                dish1,
                dish2,
                dish3,
                dish4,
                dish5
        ));

        tableRepository.save(table1);
        tableRepository.save(table2);
        tableRepository.save(table3);
        tableRepository.save(table4);
        tableRepository.save(table5);

        staffRepository.save(kitchenStaff1);
        staffRepository.save(kitchenStaff2);
        staffRepository.save(kitchenStaff3);
        staffRepository.save(kitchenStaff4);
        staffRepository.save(kitchenStaff5);

        staffRepository.save(waiter1);
        staffRepository.save(waiter2);
        staffRepository.save(waiter3);
        staffRepository.save(waiter4);
        staffRepository.save(waiter5);

        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);
        orderRepository.save(order4);
        orderRepository.save(order5);
        this.filled = true;
    }
}
