package fact.it.oefeningjpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long number;
    private String code, title, theme;
    private int duration, max;

    public Training() {
    }

    public Training(String code, String title, String theme, int duration, int max) {
        this.code = code;
        this.title = title;
        this.theme = theme;
        this.duration = duration;
        this.max = max;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long id) {
        this.number = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
