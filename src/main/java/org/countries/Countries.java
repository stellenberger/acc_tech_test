package org.countries;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

public class Countries {
    private List<Country> countries;

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public List<Country> getCountries() {
        return this.countries;
    }
}
