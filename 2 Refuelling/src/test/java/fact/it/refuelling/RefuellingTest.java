package fact.it.refuelling;

import fact.it.refuelling.model.Refuelling;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootTest
public class RefuellingTest {
    @Test
    void TestAmountInLitres() {
        Refuelling refuelling = new Refuelling(1,0,100,6);
        refuelling.setAmountInLitres(3);
        assertEquals(refuelling.getAmountInLitres(), 3);
    }
    @Test
    void TestCurrentMileage() {
        Refuelling refuelling = new Refuelling(1,0,100,6);
        refuelling.setCurrentMileage(200);
        assertEquals(refuelling.getCurrentMileage(), 200);
    }
    @Test
    void TestPreviousMileage() {
        Refuelling refuelling = new Refuelling(1,0,100,6);
        refuelling.setPreviousMileage(200);
        assertEquals(refuelling.getPreviousMileage(), 200);
    }
    @Test
    void TestId() {
        Refuelling refuelling = new Refuelling(1,0,100,6);
        refuelling.setId(200);
        assertEquals(refuelling.getId(), 200);
    }
    @Test
    void TestgetFuelConsumption() {
        Refuelling refuelling = new Refuelling(1,0,100,6);

        assertEquals(refuelling.getFuelConsumption(), 6);
    }
}
