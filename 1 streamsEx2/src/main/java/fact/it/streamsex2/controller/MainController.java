package fact.it.streamsex2.controller;


import fact.it.streamsex2.model.Course;
import fact.it.streamsex2.model.School;
import fact.it.streamsex2.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MainController {
    private School school = new School();

    @RequestMapping("/")
    public String index(Model model){
        List<Course> courseList = school.getCourseList();
        model.addAttribute("courses", courseList);
        return "index";
    }

    @RequestMapping("/searchStudents")
    public String searchStudents(HttpServletRequest request, Model model){
        String lname = request.getParameter("lastName");
        String fname = request.getParameter("firstName");
        Integer age = Integer.parseInt(request.getParameter("age"));
        Integer numberOfCourses = Integer.parseInt(request.getParameter("numberOfCourses"));
        String course = request.getParameter("courseChoice");
        List<Student> studentList = school.getFilteredList(lname, fname, age, numberOfCourses, course);
        model.addAttribute("students", studentList);
        return "details";
    }
}