package com.konar.springboot.thymeleafdemo.Model;

import java.util.List;

public class Student {

    String firstName;
    String lastName;
    String country;
    String favouriteLanguage;

    List<String> favouriteSystem;

    public List<String> getFavouriteSystem() {
        return favouriteSystem;
    }

    public void setFavouriteSystem(List<String> favouriteSystem) {
        this.favouriteSystem = favouriteSystem;
    }

    public String getFavouriteLanguage() {
        return favouriteLanguage;
    }

    public void setFavouriteLanguage(String favouriteLanguage) {
        this.favouriteLanguage = favouriteLanguage;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Student() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
