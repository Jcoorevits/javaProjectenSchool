package fact.it.oefeningassociations.controller;

import fact.it.oefeningassociations.model.*;
import fact.it.oefeningassociations.repository.ClubRepository;
import fact.it.oefeningassociations.repository.EventRepository;
import fact.it.oefeningassociations.repository.JoggerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MainController {
    private JoggerRepository joggerRepository;
    private ClubRepository clubRepository;
    private EventRepository eventRepository;

    public MainController(JoggerRepository joggerRepository, ClubRepository clubRepository, EventRepository eventRepository) {
        this.joggerRepository = joggerRepository;
        this.clubRepository = clubRepository;
        this.eventRepository = eventRepository;
    }

    @PostConstruct
    public void fillDatabaseTemporary() {
        Club kasterlee = new Club("JC Kasterlee");
        Club fiwalo = new Club("Fiwalo Willebroek");
        Jogger jogger1 = new Jogger(110, 1995, "Patrick Van Gaelen", "Geel", new Time(1, 1), Gender.Man, kasterlee);
        Jogger jogger2 = new Jogger(80, 1995, "Thomas Van Gorp", "Geel", new Time(1, 1), Gender.Woman, kasterlee);
        Jogger jogger3 = new Jogger(165, 1995, "Celien Helsen", "Geel", new Time(1, 1), Gender.X, fiwalo);
        Jogger jogger4 = new Jogger(220, 1995, "Michiel Bollen", "Geel", new Time(1, 1), Gender.X, fiwalo);

        Event event1 = new Event("Grote prijs Willebroek", 2016, "Willebroek", kasterlee);
        Event event2 = new Event("Prinsenparkloop", 2016, "Retie", fiwalo);


        clubRepository.save(kasterlee);
        clubRepository.save(fiwalo);
        eventRepository.save(event1);
        eventRepository.save(event2);
        joggerRepository.save(jogger1);
        joggerRepository.save(jogger2);
        joggerRepository.save(jogger3);
        joggerRepository.save(jogger4);
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/viewJoggers")
    public String viewJoggers(Model model) {
        List<Jogger> list = joggerRepository.findAll();
        model.addAttribute("joggerList", list);
        return "viewJoggers";
    }
    @RequestMapping("/viewEvents")
    public String viewEvents(Model model) {
        List<Event> list = eventRepository.findAll();
        model.addAttribute("eventList", list);
        return "viewEvents";
    }
    @RequestMapping("/overview")
    public String overview(Model model) {
        List<Club> list = clubRepository.findAll();
        model.addAttribute("clubList", list);
        return "overview";
    }
}