package fact.it.renovationproject.controller;

import fact.it.renovationproject.model.Renovationproject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @RequestMapping("/submitInfo")
    public String submitInfo(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        double length = Double.parseDouble(request.getParameter("length"));
        double width = Double.parseDouble(request.getParameter("width"));
        double height = Double.parseDouble(request.getParameter("height"));
        int numLayers = Integer.parseInt(request.getParameter("layers"));
        boolean ceiling = (request.getParameter("ceiling") != null);
        Renovationproject renovationproject = new Renovationproject(length, width, height);
        renovationproject.setNumberOfLayers(numLayers);
        renovationproject.setCeilingIncluded(ceiling);
        model.addAttribute("renovationproject", renovationproject);
        model.addAttribute("name", name);
        return "paint";
    }
}
