package org.countries;

import org.countries.enums.Order;

import java.util.List;

public class CountriesApplication {
        CountriesClient countriesClient;
        Countries countries;

        public CountriesApplication(CountriesClient countriesClient) {
            this.countriesClient = countriesClient;
        }

        public void fetchAllCountries() {
            this.countries = this.countriesClient.getAllCountries();
        }

        public Countries getCountries() {
            return this.countries;
        }

        public List<Country> sortByPopulationDensity(Order order) {
            return this.countries.sortByPopulationDensity(order);
        }
}
