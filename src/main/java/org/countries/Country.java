package org.countries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {
    private int population;

    private int area;

    public int getPopulation() {
        return this.population;
    }

    public float getPopulationDensity() {
        return (float) this.population / this.area;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getArea() {
        return this.area;
    }

    public void setArea(int area) {
        this.area = area;
    }
}
