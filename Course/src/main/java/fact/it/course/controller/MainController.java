package fact.it.course.controller;

import fact.it.course.model.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Controller
public class MainController {
    @RequestMapping("/submitInfo")
    public String submitInfo(HttpServletRequest request, Model model) {
        String courseName = request.getParameter("courseName");
        String location = request.getParameter("location");
        LocalDate date = LocalDate.parse(request.getParameter("date"));
        int days = Integer.parseInt(request.getParameter("days"));
        boolean weekly = (request.getParameter("weekly") != null);
        Course course = new Course(courseName, days);
        course.setLocation(location);
        course.setStartDate(date);
        course.setWeekly(weekly);
        model.addAttribute("course", course);
        return "courseinfo";
    }
}
