//Jeremy Coorevits r0843822

package fact.it.projectthemepark.model;

import java.util.ArrayList;

public class Visitor extends Person{
    private int yearOfBirth, themeParkCode;
    private ArrayList<String> wishList = new ArrayList<>();

    public Visitor(String firstName, String surName) {
        super(firstName, surName);
        this.themeParkCode = -1;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public int getThemeParkCode() {
        return themeParkCode;
    }

    public ArrayList<String> getWishList() {
        return wishList;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setThemeParkCode(int themeParkCode) {
        this.themeParkCode = themeParkCode;
    }

    public boolean addToWishList(String attractionName){
        if (wishList.size() == 5){
         return false;
        }else {
            wishList.add(attractionName);
            return true;
        }

    }
    public int getNumberOfWishes(){
        return wishList.size();
    }

    @Override
    public String toString() {
        return String.format("Visitor %s with theme park code %s", super.toString() , getThemeParkCode());
    }
}
