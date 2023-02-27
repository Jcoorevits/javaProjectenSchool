package fact.it.restaurantappstart.controller;

import fact.it.restaurantappstart.model.*;
import fact.it.restaurantappstart.repository.DishRepository;
import fact.it.restaurantappstart.repository.OrderRepository;
import fact.it.restaurantappstart.repository.StaffRepository;
import fact.it.restaurantappstart.repository.TableRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private OrderRepository orderRepository;
    private StaffRepository staffRepository;
    private DishRepository dishRepository;
    private TableRepository tableRepository;

    public OrderController(OrderRepository orderRepository, StaffRepository staffRepository, DishRepository dishRepository, TableRepository tableRepository) {
        this.orderRepository = orderRepository;
        this.staffRepository = staffRepository;
        this.dishRepository = dishRepository;
        this.tableRepository = tableRepository;
    }

    //to go to the homepage
    @RequestMapping("")
    public String manageOrder(Model model){
        List<Order> orderList = orderRepository.findAll();
        model.addAttribute("orderList",orderList);
        return "orders/orderManagement";
    }

    //to handle the advanced search request
    @RequestMapping("/advancedSearch")
    public String advancedSearch(HttpServletRequest request, Model model){
//        You give the variables a default value so that if they aren't used for filtering they return every single order
//        for example if you don't filter on tablecode your string is just "", which returns all tableCodes
        LocalDate date = LocalDate.of(2080,12,12);
        String tableNumber = "";
        double amount = 0;

//        here you check whether the parameter from the form isn't null or a spacebar (.equals)
//        if it's not null or a spacebar your variable gets the value of the input
        if (request.getParameter("date") != null && !request.getParameter("date").equals("")){
            date = LocalDate.parse(request.getParameter("date"));
        }
        if (request.getParameter("table") != null && !request.getParameter("table").equals("")){
            tableNumber = request.getParameter("table");
        }
        if (request.getParameter("amount") != null && !request.getParameter("amount").equals("")){
            amount = Double.parseDouble(request.getParameter("amount"));
        }

        //Lambda expressions suggested to make these final, otherwise they won't work
        LocalDate finalDate = date;
        String finalTableNumber = tableNumber;
        double finalAmount = amount;

        List<Order> orderList = this.orderRepository
                // Gets all items from orderRepository so you can filter on them
                .findAll()
                // Stream is like a query where you can perform operations in, but not mutable after completion
                .stream()
                // a filter to only get the orders with date before the given date
                .filter(order -> order.getDate().isBefore(finalDate))
                // a filter to only get the orders with the given table ncode
                .filter(order -> order.getTable().getCode().contains(finalTableNumber))
                // a filter to only get the orders where the total is greater than the given amount
                .filter(order -> order.getTotal() > finalAmount)
                // to convert it back to a list
                .toList();

        model.addAttribute("orderList",orderList);
        //right after the search you have the option to search again so the tableRepository (for the table dropdown) needs to be included
        List<Table> tableList = tableRepository.findAll();
        model.addAttribute("tableList",tableList);
        // you return the page advancedSearch which is located in the folder "orders"
        return "orders/advancedSearch";
    }

    //shows the details of a single order
    @RequestMapping("/{id}")
    public String detail(@PathVariable("id") Long id, Model model, HttpServletRequest request){
        // the findById gets you the id from the order that corresponds with the id thats the input. This is optional, so you have to add the orElseThrow exception
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found!"));

        // if you click on the button to pay it's no longer null so you change the setPayed to true
        if(request.getParameter("paid") != null){
            order.setPayed(true);
            orderRepository.save(order);
        }

        model.addAttribute("order",order);
        model.addAttribute("dishList",this.dishRepository.findAll());
        return "orders/details";
    }

    @RequestMapping("/create")
    public String create(Model model){
        model.addAttribute("waiterList",this.staffRepository.listOfAllWaiters());
        model.addAttribute("tableList",this.tableRepository.findAll());
        return "orders/createOrder";
    }

    @RequestMapping("/createOrder")
    public String createOrder(Model model,HttpServletRequest request){
        LocalDate date = LocalDate.now();
        boolean paid = false;

        // the findById gets you the id from the table that corresponds with what's given in the form. This is optional, so you have to add the orElsethrow
        Table table = this.tableRepository.findById(Long.parseLong(request.getParameter("table"))).orElseThrow(() -> new RuntimeException("Table not found!"));
        // Because staffRepository includes both Waiters and KitchenStaff you first have to say (Waiter) so it knows it only needs to search on dtype "Waiter"
        Waiter waiter = (Waiter) this.staffRepository.findById(Long.parseLong(request.getParameter("waiter"))).orElseThrow(() -> new RuntimeException("Waiter not found!"));
        Order order = new Order(date,paid,waiter,table);
        this.orderRepository.save(order);

        return "redirect:/orders/" + order.getId();
    }

    // Add dishes to an order
    @RequestMapping("/addToOrder/{id}")
    public String addToOrder(@PathVariable("id") Long id, Model model, HttpServletRequest request){
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found!"));

        if (request.getParameter("dish") != null & !request.getParameter("dish").equals("")){
            Dish dish = this.dishRepository.findById(Long.valueOf(request.getParameter("dish"))).orElseThrow(() -> new RuntimeException("Dish not found"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            if (request.getParameter("happyhour") != null){
                HappyHourPayment happyHourPayment = new HappyHourPayment();
                order.setPaymentStrategy(happyHourPayment);
            }
            order.addItem(dish,quantity);
            this.orderRepository.save(order);
        }
        model.addAttribute("order",order);
        model.addAttribute("dishList",this.dishRepository.findAll());
        return "orders/details";

    }
}
