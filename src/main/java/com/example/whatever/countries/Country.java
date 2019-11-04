package com.example.whatever.countries;

import java.util.concurrent.atomic.AtomicLong;

public class Country {
    private String name;
    private int population;
    private int landMass;
    private int medianAge;
    private static final AtomicLong counter = new AtomicLong();
  /*  Each country object will contain

    a country name, population, land mass size, and median age
    should contain the standard getter and setters*/

    public Country(String name, int population, int landMass, int medianAge) {
        this.name = name;
        this.population = population;
        this.landMass = landMass;
        this.medianAge = medianAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getLandMass() {
        return landMass;
    }

    public void setLandMass(int landMass) {
        this.landMass = landMass;
    }

    public int getMedianAge() {
        return medianAge;
    }

    public void setMedianAge(int medianAge) {
        this.medianAge = medianAge;
    }


}
