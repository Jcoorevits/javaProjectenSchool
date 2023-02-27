package fact.it.restaurantappstart.controller;

import fact.it.restaurantappstart.model.KitchenStaff;
import fact.it.restaurantappstart.model.Staff;
import fact.it.restaurantappstart.model.Waiter;
import fact.it.restaurantappstart.repository.DishRepository;
import fact.it.restaurantappstart.repository.OrderRepository;
import fact.it.restaurantappstart.repository.StaffRepository;
import fact.it.restaurantappstart.repository.TableRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {

    private StaffRepository staffRepository;

    public StaffController(StaffRepository staffRepository) {

        this.staffRepository = staffRepository;

    }

    //No slash is used because you are in another folder
    @RequestMapping("")
    public String manageStaff(Model model){
        List<Staff> staffList= staffRepository.findAll();
//        model.addAttribute("staffList",staffList);
        model.addAttribute("staffList",staffRepository.findAll());
        return "staff/staffManagement";
    }

    @RequestMapping("/create")
    public String create(Model model){
        //you make a new List to get the dropdown box filled with Waiter and KitchenStaff.
        List<String> types = new ArrayList<>();
        types.add("Waiter");
        types.add("KitchenStaff");
        model.addAttribute("staffTypes",types);
        return "staff/createStaff";
    }

    @RequestMapping("/addStaffMember")
    public String addStaffMember(HttpServletRequest request, Model model){
        String name = request.getParameter("name");
        String type = request.getParameter("staffType");

        // Here you check whether the value you selected in the dropdown box is Waiter or KitchenStaff and makes the appropiate enityt
        if (type.equals("Waiter")){
            Waiter waiter = new Waiter();
            waiter.setName(name);
            staffRepository.save(waiter);
        }
        else if (type.equals("KitchenStaff")){
            KitchenStaff kitchenStaff = new KitchenStaff();
            kitchenStaff.setName(name);
            staffRepository.save(kitchenStaff);
        }

        //this redirects to the homepage of this controller (aka the @RequestMapping(""), from line 31 from this controller
        return "redirect:";
    }
}
