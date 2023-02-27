package fact.it.oefeningassociations;

import fact.it.oefeningassociations.model.Club;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClubTests {
    @Test
    void TestId(){
        Club club = new Club("JeKa","Kasterlee",12.5);
        club.setId(5);
        assertEquals(club.getId(),5);
    }

    @Test
    void TestLocation(){
        Club club = new Club("JeKa","Kasterlee",12.5);
        club.setLocation("Retie");
        assertEquals(club.getLocation(),"Retie");
    }

    @Test
    void TestMemberfee(){
        Club club = new Club("JeKa","Kasterlee",12.5);
        club.setMemberfee(25);
        assertEquals(club.getMemberfee(),25);
    }


}