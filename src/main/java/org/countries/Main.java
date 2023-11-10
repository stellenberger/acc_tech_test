package org.countries;

import org.countries.enums.Order;

public class Main {
    public static void main(String[] args) {
        CountriesClient countriesClient = new CountriesClient();

        CountriesApplication countriesApplication = new CountriesApplication(countriesClient);

        countriesApplication.fetchAllCountries();

        countriesApplication.printSortedCountriesByPopulationDensity(Order.DESCENDING);

        Country country = countriesApplication.asianCountryWithMostBorderingCountriesFromOutsideAsia();
        System.out.println("The country in asia with the most bordering countries outside of asia is: " + country.getName());
    }
}