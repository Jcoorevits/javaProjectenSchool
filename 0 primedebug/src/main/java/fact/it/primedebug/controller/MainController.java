package fact.it.primedebug.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/submit")
    public String calculate(Model model, HttpServletRequest request){

        int maxNumber = Integer.parseInt(request.getParameter("maxNumber"));
        ArrayList<Integer> primes = new ArrayList<>();

        // Find all prime numbers up until the given number
        for (int i = 1; i <= maxNumber; i++) {
            if (IsPrime(i)) {
                primes.add(i);
            }
        }

        model.addAttribute("solutionList", primes);
        return "solution";
    }

    private boolean IsPrime(int number) {
        // Check if a given number is a prime
        int boundary = (int)Math.sqrt(number);
        if (number <= 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        // Even numbers are never prime
        if (number % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= boundary; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
