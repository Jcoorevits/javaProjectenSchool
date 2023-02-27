package fact.it.startproject.repository;

import fact.it.startproject.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query("select p from Payment p order by p.amount ASC")
    List<Payment> giveListOfAllPaymentsAsc();

    @Query("select p from CashPayment p")
    List<Payment> giveListOfAllCashPayments();

    @Query("select p from ElectronicPayment p order by p.currency")
    List<Payment> giveListOfAllElectronicPayments();

    List<Payment> findAllByAmountGreaterThan(double amount);


}
