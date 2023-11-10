package org.countries;

import org.countries.enums.Order;

public class Main {
    public static void main(String[] args) {
        CountriesClient countriesClient = new CountriesClient();

        CountriesApplication countriesApplication = new CountriesApplication(countriesClient);

        countriesApplication.fetchAllCountries();

        countriesApplication.sortByPopulationDensity(Order.DESCENDING);
    }
}