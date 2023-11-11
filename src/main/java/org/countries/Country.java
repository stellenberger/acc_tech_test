package org.countries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {
    private int population;
    private int area;
    private String region;
    private CountryName name;
    private String cca3;
    private List<String> borders = new ArrayList<>();

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

    public String getRegion() {
        return this.region;
    }

    public String getCca3() {
        return this.cca3;
    }

    public List<String> getBorders() {
        return this.borders;
    }

    public String getName() {
        return this.name.getCommon();
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCca3(String cca3) {
        this.cca3 = cca3;
    }

    public void setName(CountryName name) {
        this.name = name;
    }

    public void setBorders(List<String> borders) {
        this.borders = borders;
    }
}
