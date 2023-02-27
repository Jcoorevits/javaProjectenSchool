package fact.it.restaurantappstart.controller;

import fact.it.restaurantappstart.model.*;
import fact.it.restaurantappstart.repositories.DishRepository;
import fact.it.restaurantappstart.repositories.OrderRepository;
import fact.it.restaurantappstart.repositories.StaffRepository;
import fact.it.restaurantappstart.repositories.TableRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SecondController {
    private DishRepository dishRepository;
    private StaffRepository staffRepository;
    private OrderRepository orderRepository;
    private TableRepository tableRepository;


    public SecondController(DishRepository dishRepository, StaffRepository staffRepository, OrderRepository orderRepository, TableRepository tableRepository) {
        this.dishRepository = dishRepository;
        this.staffRepository = staffRepository;
        this.orderRepository = orderRepository;
        this.tableRepository = tableRepository;
    }


    @RequestMapping("/manageStaff")
    public String manageStaff(Model model) {
        List<Staff> staffList = staffRepository.findAll();
        List<String> types = new ArrayList<>();
        types.add("Waiter");
        types.add("KitchenStaff");
        model.addAttribute("staffTypes", types);
        model.addAttribute("stafflist", staffList);
        return "manageStaff";
    }

    @RequestMapping("/manageOrders")
    public String manageOrders(Model model) {
        List<Order> orderList = orderRepository.findAll();
        model.addAttribute("orderList", orderList);
        return "manageOrders";
    }

    @RequestMapping("/addToOrder/{id}")
    public String addToOrder(@PathVariable("id") Long id, Model model, HttpServletRequest request) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found!"));

        if (request.getParameter("dish") != null & !request.getParameter("dish").equals("")) {
            Dish dish = this.dishRepository.findById(Long.valueOf(request.getParameter("dish"))).orElseThrow(() -> new RuntimeException("Dish not found"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            if (request.getParameter("happyhour") != null) {
                HappyHourPayment happyHourPayment = new HappyHourPayment();
                order.setPaymentStrategy(happyHourPayment);
            }
            order.addItem(dish, quantity);
            this.orderRepository.save(order);
        }
        model.addAttribute("order", order);
        model.addAttribute("dishList", this.dishRepository.findAll());
        return "details";

    }

    @RequestMapping("/orderSearch")
    public String orderSearch(Model model) {
        model.addAttribute("tableList", this.tableRepository.findAll());
        return "orderSearch";
    }

    @RequestMapping("/details/{id}")
    public String detail(@PathVariable("id") Long id, Model model, HttpServletRequest request) {
        // the findById gets you the id from the order that corresponds with the id thats the input. This is optional, so you have to add the orElseThrow exception
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found!"));

        // if you click on the button to pay it's no longer null so you change the setPayed to true
        if (request.getParameter("paid") != null) {
            order.setPayed(true);
            orderRepository.save(order);
        }

        model.addAttribute("order", order);
        model.addAttribute("dishList", this.dishRepository.findAll());
        return "details";
    }

    @RequestMapping("/searchOrders")
    public String searchOrderTable(Model model, HttpServletRequest request) {
        LocalDate localDate = LocalDate.now();
        String tableCode = "";
        double amount = 0;

        if (request.getParameter("date") != null && !request.getParameter("date").equals("")) {
            localDate = LocalDate.parse(request.getParameter("date"));
        }
        if (request.getParameter("table") != null && !request.getParameter("table").equals("")) {
            tableCode = request.getParameter("table");
        }
        if (request.getParameter("amount") != null && !request.getParameter("amount").equals("")) {
            amount = Double.parseDouble(request.getParameter("amount"));
        }

        // Lambda expressions need a "final" value.
        LocalDate finalLocalDate = localDate;
        String finalTableCode = tableCode;
        double finalAmount = amount;

        List<Order> orderList = this.orderRepository
                // Set all items into a list to use in the stream.
                .findAll()
                // Stream is like a query where you can perform operations in, but not mutable after completion.
                .stream()
                // Filter: only get orders before this date.
                .filter(order -> order.getDate().isBefore(finalLocalDate))
                // Filter: only get orders from the specific table.
                .filter(order -> order.getTable().getCode().contains(finalTableCode))
                // Filter: only get orders that are above this amount.
                .filter(order -> order.getTotal() > finalAmount)
                .toList();

        // the table list for the dropdown.
        List<Table> tableList = this.tableRepository.findAll();
        model.addAttribute("orderList", orderList);
        model.addAttribute("tableList", tableList);

        return "manageOrders";
    }

    //    @RequestMapping("/searchOrderTable")
//    public String searchOrderTable(Model model, HttpServletRequest request) {
//        String code = request.getParameter("searchTable");
//        List<Order> orderList = orderRepository.findOrdersByTableCode(code);
////        orderList.stream().map(i -> i.getTable().getCode().equals(code));
//        model.addAttribute("orderList", orderList);
//        return "manageOrders";
//    }
//
//    @RequestMapping("/searchOrderDate")
//    public String searchOrderDate(Model model, HttpServletRequest request) {
//        LocalDate date = LocalDate.parse(request.getParameter("searchDate"));
//        List<Order> orderList = orderRepository.findOrdersByDateBefore(date);
//        model.addAttribute("orderList", orderList);
//        return "manageOrders";
//    }
//    @RequestMapping("/searchTotal")
//    public String searchTotal(Model model, HttpServletRequest request) {
//        double total = Double.parseDouble(request.getParameter("searchTotal"));
//        List<Order> orderList = orderRepository.findOrdersByTotalLessThan(total);
//        model.addAttribute("orderList", orderList);
//        return "manageOrders";
//    }

    @RequestMapping("/addStaff")
    public String index(Model model, HttpServletRequest request) {
        String name = request.getParameter("name");
        boolean kitchenStaff = (request.getParameter("kitchenStaff") != null);
        boolean waiter = (request.getParameter("waiter") != null);

        if (kitchenStaff) {
            KitchenStaff kitchenStaff1 = new KitchenStaff(name);
            kitchenStaff1.setName(name);
            staffRepository.save(kitchenStaff1);
            List<Staff> staffList = staffRepository.findAll();
            model.addAttribute("stafflist", staffList);
        } else if (waiter) {
            Waiter waiter1 = new Waiter(name);
            waiter1.setName(name);
            staffRepository.save(waiter1);
            List<Staff> staffList = staffRepository.findAll();
            model.addAttribute("stafflist", staffList);
        }

        return "manageStaff";
    }
    @RequestMapping("/create")
    public String create(Model model){
        model.addAttribute("waiterList",this.staffRepository.listOfAllWaiters());
        model.addAttribute("tableList",this.tableRepository.findAll());
        return "createOrder";
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

        return "redirect:/details/" + order.getId();
    }
}
