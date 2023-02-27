//Jeremy Coorevits r0843822

package fact.it.projectthemepark.controller;

import fact.it.projectthemepark.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class MainController {

    private ArrayList<Staff> staffMembers;
    private ArrayList<Visitor> visitors;
    private ArrayList<ThemePark> themeParks;

    @PostConstruct
    public void fillData() {
        staffMembers = fillStaffMembers();
        visitors = fillVisitors();
        themeParks = fillThemeParks();
    }


    @RequestMapping("/1_newvisitor")
    public String newVisitor(Model model) {
        model.addAttribute("themeparks", themeParks);
        return "1_newvisitor";
    }

    @RequestMapping("/2_welcomevisitor")
    public String welcomeVisitor(HttpServletRequest request, Model model) {
        String fname = request.getParameter("fname");
        String sname = request.getParameter("sname");
        int birthdate = Integer.parseInt(request.getParameter("birthyear"));
        int themepark = Integer.parseInt(request.getParameter("themepark"));
        Visitor visitor = new Visitor(fname, sname);
        visitor.setYearOfBirth(birthdate);
        themeParks.get(themepark).registerVisitor(visitor);
        visitors.add(visitor);
        model.addAttribute("visitor", visitor);
        return "2_welcomevisitor";
    }

    @RequestMapping("/3_newstaff")
    public String newStaff(Model model) {
        model.addAttribute("themeparks", themeParks);
        return "3_newstaff";
    }

    @RequestMapping("/0_exam")
    public String exam(HttpServletRequest request, Model model) {
        int themeParkIndex = Integer.parseInt(request.getParameter("themepark"));
        if (themeParkIndex < 0) {
            model.addAttribute("errormessage", "You didn't choose a theme park!");
            return "error";
        }
        String sfname = request.getParameter("sfname");
        String ssname = request.getParameter("ssname");
        LocalDate employyear = LocalDate.parse(request.getParameter("employyear"));
        boolean student = (request.getParameter("student") != null);
        Staff staff = new Staff(sfname, ssname);
        staff.setStartDate(employyear);
        staff.setStudent(student);
        staff.setEmployedAt(themeParks.get(themeParkIndex));
        staffMembers.add(staff);
        model.addAttribute("staff", staff);
        return "0_exam";
    }

    @RequestMapping("/5_savedStaff")
    public String savedStaff(Model model) {
        model.addAttribute("staffMembers", staffMembers);
        return "5_savedStaff";
    }

    @RequestMapping("/6_savedVisitors")
    public String savedVisitors(Model model) {
        model.addAttribute("visitors", visitors);
        return "6_savedVisitors";
    }

    @RequestMapping("/7_newThemePark")
    public String newThemePark() {
        return "/7_newThemePark";
    }

    @RequestMapping("/submitNewThemePark")
    public String submitNewThemeParks(HttpServletRequest request, Model model) {
        String tname = request.getParameter("tname");
        ThemePark themePark = new ThemePark(tname);
        themeParks.add(themePark);
        model.addAttribute("themeparks", themeParks);
        return "8_themeParks";
    }

    @RequestMapping("/8_themeParks")
    public String themeParks(Model model) {
        model.addAttribute("themeparks", themeParks);
        return "8_themeParks";
    }

    @RequestMapping("/9_newAttraction")
    public String newAttraction(HttpServletRequest request, Model model) {
        model.addAttribute("themeparks", themeParks);
        model.addAttribute("staffmembers", staffMembers);
        return "9_newAttraction";
    }

    @RequestMapping("/10_allAttractions")
    public String allAttractions(HttpServletRequest request, Model model) {
        int themepark = Integer.parseInt(request.getParameter("themepark"));
        String attractionName = request.getParameter("aname");
        String photo = request.getParameter("photo");
        int duration = Integer.parseInt(request.getParameter("duration"));
        int staffmember = Integer.parseInt(request.getParameter("staffmember"));
        if (themepark < 0) {
            model.addAttribute("errormessage", "You didn't choose a theme park!");
            return "error";
        }
        if (staffmember < 0) {
            model.addAttribute("errormessage", "You didn't choose a staff member!");
            return "error";
        }
        Attraction newAttraction = new Attraction(attractionName, duration);
        newAttraction.setPhoto(photo);
        newAttraction.setResponsible(staffMembers.get(staffmember));
        themeParks.get(themepark).addAttraction(newAttraction);
        model.addAttribute("themeparks", themeParks.get(themepark));

        return "10_allAttractions";
    }

    @RequestMapping("/showThemePark")
    public String showThemePark(HttpServletRequest request, Model model) {
        int parkIndex = Integer.parseInt(request.getParameter("parkIndex"));
        model.addAttribute("themeparks", themeParks.get(parkIndex));

        return "10_allAttractions";
    }


    @RequestMapping("/searchAttraction")
    public String submitThemePark(HttpServletRequest request, Model model) {
        String searchAttraction = request.getParameter("attraction");
        for (ThemePark park : themeParks) {
            if (park.searchAttractionByName(searchAttraction) != null) {
                model.addAttribute("attraction", park.searchAttractionByName(searchAttraction));
                return "11_searchAttraction";
            }

        }
        model.addAttribute("errormessage", "There is no attraction with the name '" + searchAttraction + "'");
        return "error";
    }


    private ArrayList<Staff> fillStaffMembers() {
        ArrayList<Staff> staffMembers = new ArrayList<>();

        Staff staff1 = new Staff("Johan", "Bertels");
        staff1.setStartDate(LocalDate.of(2002, 5, 1));
        Staff staff2 = new Staff("An", "Van Herck");
        staff2.setStartDate(LocalDate.of(2019, 3, 15));
        staff2.setStudent(true);
        Staff staff3 = new Staff("Bruno", "Coenen");
        staff3.setStartDate(LocalDate.of(1995, 1, 1));
        Staff staff4 = new Staff("Wout", "Dayaert");
        staff4.setStartDate(LocalDate.of(2002, 12, 15));
        Staff staff5 = new Staff("Louis", "Petit");
        staff5.setStartDate(LocalDate.of(2020, 8, 1));
        staff5.setStudent(true);
        Staff staff6 = new Staff("Jean", "Pinot");
        staff6.setStartDate(LocalDate.of(1999, 4, 1));
        Staff staff7 = new Staff("Ahmad", "Bezeri");
        staff7.setStartDate(LocalDate.of(2009, 5, 1));
        Staff staff8 = new Staff("Hans", "Volzky");
        staff8.setStartDate(LocalDate.of(2015, 6, 10));
        staff8.setStudent(true);
        Staff staff9 = new Staff("Joachim", "Henau");
        staff9.setStartDate(LocalDate.of(2007, 9, 18));
        staffMembers.add(staff1);
        staffMembers.add(staff2);
        staffMembers.add(staff3);
        staffMembers.add(staff4);
        staffMembers.add(staff5);
        staffMembers.add(staff6);
        staffMembers.add(staff7);
        staffMembers.add(staff8);
        staffMembers.add(staff9);
        return staffMembers;
    }

    private ArrayList<Visitor> fillVisitors() {
        ArrayList<Visitor> visitors = new ArrayList<>();
        Visitor visitor1 = new Visitor("Dominik", "Mioens");
        visitor1.setYearOfBirth(2001);
        Visitor visitor2 = new Visitor("Zion", "Noops");
        visitor2.setYearOfBirth(1996);
        Visitor visitor3 = new Visitor("Maria", "Bonetta");
        visitor3.setYearOfBirth(1998);
        Visitor visitor4 = new Visitor("Jeremy", "Coorevits");
        visitor4.setYearOfBirth(1995);
        visitors.add(visitor1);
        visitors.add(visitor2);
        visitors.add(visitor3);
        visitors.add(visitor4);
        visitors.get(0).addToWishList("De grote golf");
        visitors.get(0).addToWishList("Sky Scream");
        visitors.get(1).addToWishList("Piratenboot");
        visitors.get(1).addToWishList("Sky Scream");
        visitors.get(1).addToWishList("Halvar the ride");
        visitors.get(1).addToWishList("DreamCatcher");
        visitors.get(2).addToWishList("DinoSplash");
        visitors.get(3).addToWishList("Piratenboot");
        visitors.get(3).addToWishList("Sky Scream");
        return visitors;
    }

    private ArrayList<ThemePark> fillThemeParks() {
        ArrayList<ThemePark> themeparks = new ArrayList<>();
        ThemePark themepark1 = new ThemePark("Plopsaland");
        ThemePark themepark2 = new ThemePark("Plopsa Coo");
        ThemePark themepark3 = new ThemePark("Holiday Park");
        Attraction attraction1 = new Attraction("Anubis the Ride", 60);
        Attraction attraction2 = new Attraction("De grote golf", 180);
        Attraction attraction3 = new Attraction("Piratenboot", 150);
        Attraction attraction4 = new Attraction("SuperSplash", 258);
        Attraction attraction5 = new Attraction("Dansende fonteinen");
        Attraction attraction6 = new Attraction("Halvar the ride", 130);
        Attraction attraction7 = new Attraction("DinoSplash", 240);
        Attraction attraction8 = new Attraction("Bounty Tower", 180);
        Attraction attraction9 = new Attraction("Sky Scream", 50);
        attraction1.setPhoto("/img/anubis the ride.jpg");
        attraction2.setPhoto("/img/de grote golf.jpg");
        attraction3.setPhoto("/img/piratenboot.jpg");
        attraction4.setPhoto("/img/supersplash.jpg");
        attraction5.setPhoto("/img/dansende fonteinen.jpg");
        attraction6.setPhoto("/img/halvar the ride.jpg");
        attraction7.setPhoto("/img/dinosplash.jpg");
        attraction8.setPhoto("/img/bountytower.jpg");
        attraction9.setPhoto("/img/sky scream.jpg");
        attraction1.setResponsible(staffMembers.get(0));
        attraction2.setResponsible(staffMembers.get(1));
        attraction3.setResponsible(staffMembers.get(2));
        attraction4.setResponsible(staffMembers.get(3));
        attraction5.setResponsible(staffMembers.get(4));
        attraction6.setResponsible(staffMembers.get(5));
        attraction7.setResponsible(staffMembers.get(6));
        attraction8.setResponsible(staffMembers.get(7));
        attraction9.setResponsible(staffMembers.get(8));
        themepark1.addAttraction(attraction1);
        themepark1.addAttraction(attraction2);
        themepark1.addAttraction(attraction3);
        themepark1.addAttraction(attraction4);
        themepark2.addAttraction(attraction5);
        themepark2.addAttraction(attraction6);
        themepark3.addAttraction(attraction7);
        themepark3.addAttraction(attraction8);
        themepark3.addAttraction(attraction9);
        themeparks.add(themepark1);
        themeparks.add(themepark2);
        themeparks.add(themepark3);
        return themeparks;
    }


}

