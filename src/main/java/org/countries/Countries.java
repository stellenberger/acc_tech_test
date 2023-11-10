package org.countries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.countries.enums.Order;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Countries {
    private List<Country> countries;

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public List<Country> getCountries() {
        return this.countries;
    }

    public List<Country> sortByPopulationDensity(Order order) {
        Comparator<Country> comparator = order == Order.ASCENDING ?
                Comparator.comparing(Country::getPopulationDensity) :
                Comparator.comparing(Country::getPopulationDensity).reversed();

        return this.countries.stream().sorted(comparator)
                .collect(Collectors.toList());
    }

    public List<String> getAllAsianCca3() {
        return getAsianCountries().stream().map(Country::getCca3).collect(Collectors.toList());
    }

    public List<Country> getAsianCountries() {
        return countries.stream().filter(country -> country.getRegion().equals("Asia"))
                .collect(Collectors.toList());
    }
}
