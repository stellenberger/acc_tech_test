package org.countries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {
    private int population;

    private int area;

    public int getPopulation() {
        return this.population;
    }

    public int getPopulationDensity() {
        return this.population / this.area;
    }
}
