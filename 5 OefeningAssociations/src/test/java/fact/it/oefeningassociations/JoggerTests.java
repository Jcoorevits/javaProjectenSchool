package fact.it.oefeningassociations;

import fact.it.oefeningassociations.model.Club;
import fact.it.oefeningassociations.model.Gender;
import fact.it.oefeningassociations.model.Jogger;
import fact.it.oefeningassociations.model.Time;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JoggerTests {
    @Test
    void TestId(){
        Jogger jogger = new Jogger(20,"Zico",1998,"Geel", Gender.Man);
        jogger.setId(2);
        assertEquals(jogger.getId(),2);
    }
    @Test
    void TestBibNumber(){
        Jogger jogger = new Jogger(20,"Zico",1998,"Geel", Gender.Man);
        jogger.setBibNumber(10);
        assertEquals(jogger.getBibNumber(),10);
    }

    @Test
    void TestName(){
        Jogger jogger = new Jogger(20,"Zico",1998,"Geel", Gender.Man);
        jogger.setName("Tony");
        assertEquals(jogger.getName(),"Tony");
    }

    @Test
    void TestBirthYear(){
        Jogger jogger = new Jogger(20,"Zico",1998,"Geel", Gender.Man);
        jogger.setYearOfBirth(2001);
        assertEquals(jogger.getYearOfBirth(),2001);
    }

    @Test
    void TestLocation(){
        Jogger jogger = new Jogger(20,"Zico",1998,"Geel", Gender.Man);
        jogger.setLocation("Kasterlee");
        assertEquals(jogger.getLocation(),"Kasterlee");
    }

    @Test
    void TestGender(){
        Jogger jogger = new Jogger(20,"Zico",1998,"Geel", Gender.Man);
        jogger.setGender(Gender.Man);
        assertEquals(jogger.getGender(),Gender.Man);
    }

    @Test
    void TestTime(){
        Jogger jogger = new Jogger(20,"Zico",1998,"Geel", Gender.Man);
        Time time = new Time(25,40);
        jogger.setTime(time);
        assertEquals(jogger.getTime(),time);
    }

    @Test
    void TestClub(){
        Jogger jogger = new Jogger(20,"Zico",1998,"Geel", Gender.Man);
        Club club = new Club();
        club.setName("Party");
        jogger.setClub(club);
        assertEquals(jogger.getClub(),club);
    }
}
