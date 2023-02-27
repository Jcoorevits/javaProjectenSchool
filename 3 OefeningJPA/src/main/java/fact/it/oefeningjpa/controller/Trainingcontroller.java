package fact.it.oefeningjpa.controller;


import fact.it.oefeningjpa.model.Training;
import fact.it.oefeningjpa.repository.TrainingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class Trainingcontroller {

    private TrainingRepository trainingRepository;

    public Trainingcontroller(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/admin")
    public String admin(Model model) {
        List<Training> list = trainingRepository.findAll();
        model.addAttribute("trainingList", list);
        return "admin";
    }

    @RequestMapping("/add")
    public String add() {
        return "add";
    }

    @RequestMapping("/processadd")
    public String processAdd(Model model, HttpServletRequest request) {
        String code = request.getParameter("code");
        String title = request.getParameter("title");
        String theme = request.getParameter("theme");
        int duration = Integer.parseInt(request.getParameter("duration"));
        int max = Integer.parseInt(request.getParameter("max"));
        Training training = new Training(code, title, theme, duration, max);
        trainingRepository.save(training);
        List<Training> list = trainingRepository.findAll();
        model.addAttribute("trainingList", list);
        return "admin";
    }

    @RequestMapping("/edit")
    public String edit(Model model, HttpServletRequest request) {
        Long trainingId = Long.valueOf(request.getParameter("trainingId"));
        //breadRepository.findById(breadId) returns an Optional, a value that can also be null. By using the .get()-method we can retrieve the actual value.
        Training training = trainingRepository.findById(trainingId).orElseThrow(() -> new RuntimeException("Order not found!"));
        model.addAttribute("training", training);
        return "edit";
    }

    @RequestMapping("/processedit")
    public String processEdit(Model model, HttpServletRequest request) {
        Long trainingId = Long.valueOf(request.getParameter("trainingId"));
        String code = request.getParameter("code");
        String title = request.getParameter("title");
        String theme = request.getParameter("theme");
        int duration = Integer.parseInt(request.getParameter("duration"));
        int max = Integer.parseInt(request.getParameter("max"));

        //breadRepository.findById(breadId) returns an Optional, a value that can also be null. By using the .get()-method we can retrieve the actual value.
        Training training = trainingRepository.findById(trainingId).orElseThrow(() -> new RuntimeException("Order not found!"));
        training.setCode(code);
        training.setTitle(title);
        training.setTheme(theme);
        training.setDuration(duration);
        training.setMax(max);
        trainingRepository.save(training);
        List<Training> list = trainingRepository.findAll();
        model.addAttribute("trainingList", list);
        return "admin";
    }

    @RequestMapping("/delete")
    public String delete(Model model, HttpServletRequest request) {
        Long trainingId = Long.valueOf(request.getParameter("trainingId"));
        trainingRepository.deleteById(trainingId);
        //    List<Bread> list = breadRepository.findAll();
        List<Training> list = trainingRepository.findAll();
        model.addAttribute("trainingList", list);
        return "admin";
    }

    @RequestMapping("/trainingByTheme")
    public String trainingByTheme(Model model) {
        List<Training> list = trainingRepository.giveListOfAllTrainingsSortedByTheme();
        model.addAttribute("trainingList", list);
        return "admin";
    }

    @RequestMapping("/details")
    public String show(Model model, HttpServletRequest request) {
        Long trainingId = Long.valueOf(request.getParameter("trainingId"));
        Training training = trainingRepository.findById(trainingId).orElseThrow(() -> new RuntimeException("Order not found!"));;
        model.addAttribute("training", training);
        return "show";


    }

    @RequestMapping("/advancedSearch")
    public String advancedSearch(Model model) {
        List<String> themesList = trainingRepository.giveListOfAllThemes();
        model.addAttribute("themesList", themesList);
        return "advanced_search";
    }

    @RequestMapping("/search")
    public String search(Model model, HttpServletRequest request) {
        // null werkt niet!!!
        if (request.getParameter("searchTitle") != "") {
            String searchTitle = request.getParameter("searchTitle");
            List<Training> list = trainingRepository.findAllByTitleContaining(searchTitle);
            model.addAttribute("trainingList", list);
        }
        // null werkt niet!!!
        if (request.getParameter("searchTheme") != "") {
            List<Training> list = trainingRepository.findAllByTheme(request.getParameter("searchTheme"));
            model.addAttribute("trainingList", list);
        }
        return "admin";
    }
}
