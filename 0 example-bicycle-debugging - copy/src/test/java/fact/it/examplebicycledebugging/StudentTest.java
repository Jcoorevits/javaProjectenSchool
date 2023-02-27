package fact.it.examplebicycledebugging;

import fact.it.examplebicycledebugging.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentTest {
    @Test
    public void testNoArgConstructorAndGetters() {

        Student student = new Student();
        assertEquals(null, student.getRnumber());
        assertEquals(null, student.getFirstName());
        assertEquals(null, student.getSurname());
        assertEquals(false, student.isForeigner());

    }

    @Test
    public void testConstructorWithParametersAndGetters() {

        Student student = new Student("r123456", "Jan", "Janssen");
        assertEquals("r123456", student.getRnumber());
        assertEquals("Jan", student.getFirstName());
        assertEquals("Janssen", student.getSurname());
        assertEquals(false, student.isForeigner());

    }

    @Test
    public void testSetFirstName() {
        Student student = new Student();

        student.setFirstname("Lies");
        assertEquals("Lies", student.getFirstName());
    }

    @Test
    public void testSetSurname() {
        Student student = new Student();

        student.setSurname("Peeters");
        assertEquals("Peeters", student.getSurname());
    }

    @Test
    public void testSetForeigner() {
        Student student = new Student();

        student.setForeigner(true);
        assertEquals(true, student.isForeigner());
    }

    @Test
    public void testGetEmailAddress() {
        Student student = new Student("r123456", "Jan", "Janssen");
        assertEquals("r123456@student.thomasmore.be", student.getEmailAddress());
    }

    @Test
    public void testGetInitials() {
        Student student = new Student("r123456", "Jan", "Janssen");
        assertEquals("JJa", student.getInitials());
    }

    @Test
    public void testGetFullName() {
        Student student = new Student("r123456", "Jan", "Janssen");
        assertEquals("Jan JANSSEN (JJa)", student.getFullName());
    }



}
