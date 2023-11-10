package org.countries;

public class Main {
    public static void main(String[] args) {
        CountriesClient countriesClient = new CountriesClient();

        CountriesApplication countriesApplication = new CountriesApplication(countriesClient);

        countriesApplication.fetchAllCountries();
    }
}