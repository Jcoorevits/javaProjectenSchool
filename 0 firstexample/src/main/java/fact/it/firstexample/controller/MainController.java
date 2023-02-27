package fact.it.firstexample.controller;

import org.springframework.stereotype. Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController { @RequestMapping("/") public String studentInfo(Model model){ model.addAttribute("firstname", "Kristine"); return "studentinfo";
}}
