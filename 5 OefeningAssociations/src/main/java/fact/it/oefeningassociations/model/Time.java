package fact.it.oefeningassociations.model;

import javax.persistence.Embeddable;

@Embeddable
public class Time {

    private int minutes = 0;

    private int seconds;

    public Time() {
    }

    public Time(int minutes, int seconds) {
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
}
