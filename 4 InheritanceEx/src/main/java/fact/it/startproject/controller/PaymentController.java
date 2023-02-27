package fact.it.startproject.controller;

import fact.it.startproject.model.AmexPayment;
import fact.it.startproject.model.CashPayment;
import fact.it.startproject.model.Payment;
import fact.it.startproject.model.VisaPayment;
import fact.it.startproject.repository.PaymentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Random;

@Controller
public class PaymentController {

    private PaymentRepository paymentRepository;

    public PaymentController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @PostConstruct
    public void fillDatabaseTemporary() {
        // CashPayment
        for (int i = 1; i <= 5; i++) {
            Random rand = new Random();
            // Obtain a number between [0 - 499].
            double n = rand.nextInt(500);
            CashPayment cashPayment = new CashPayment("JeremyCash" + i, "EUR", n, "cashPayment" + i);
            paymentRepository.save(cashPayment);
        }
        // VisaPayment
        for (int i = 1; i <= 3; i++) {
            Random rand = new Random();
            // Obtain a number between [0 - 499].
            double n = rand.nextInt(500);
            VisaPayment visaPayment = new VisaPayment("JeremyVisa" + i, "EUR", n, "JeremyV", "Account" + i, "670369692222333" + i, "202" + i);
            paymentRepository.save(visaPayment);
        }
        // AmexPayment
        for (int i = 1; i <= 2; i++) {
            Random rand = new Random();
            // Obtain a number between [0 - 499].
            double n = rand.nextInt(500);
            AmexPayment amexPayment = new AmexPayment("JeremyAmex" + i, "EUR", n, "JeremyA", "Account" + i, 1234 + i);
            paymentRepository.save(amexPayment);
        }
    }

    @RequestMapping("/")
    public String index(Model model) {
        List<Payment> list = paymentRepository.findAll();
        model.addAttribute("paymentList", list);
        return "index";
    }

    @RequestMapping("ascending")
    public String ascending(Model model) {
        List<Payment> list = paymentRepository.giveListOfAllPaymentsAsc();
        model.addAttribute("paymentList", list);
        return "result";
    }
    @RequestMapping("cash")
    public String cash(Model model) {
        List<Payment> list = paymentRepository.giveListOfAllCashPayments();
        model.addAttribute("paymentList", list);
        return "result";
    }
    @RequestMapping("electronic")
    public String electronic(Model model) {
        List<Payment> list = paymentRepository.giveListOfAllElectronicPayments();
        model.addAttribute("paymentList", list);
        return "result";
    }
    @RequestMapping("greater")
    public String amount(Model model, HttpServletRequest request) {
        double amount = Double.parseDouble(request.getParameter("amount"));
        List<Payment> list = paymentRepository.findAllByAmountGreaterThan(amount);
        model.addAttribute("paymentList", list);
        return "result";
    }
}
