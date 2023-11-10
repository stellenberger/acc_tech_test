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

        public Country asianCountryWithMostBorderingCountriesFromOutsideAsia() {
            List<String> asianCca3 = countries.getAllAsianCca3();

            List<Country> asianCountries = countries.getAsianCountries();

            Country countryWithMostBordersWithOutsideAsia = null;

            int recordNumberOfBordersOutsideAsia = 0;

            for (Country country : asianCountries) {
                int numberOfBordersWithOutsideAsia = 0;

                for (String border : country.getBorders()) {
                    if (!asianCca3.contains(border)) {
                        numberOfBordersWithOutsideAsia++;
                    }
                }

                if (countryWithMostBordersWithOutsideAsia == null) {
                    countryWithMostBordersWithOutsideAsia = country;
                    recordNumberOfBordersOutsideAsia = numberOfBordersWithOutsideAsia;
                } else if (numberOfBordersWithOutsideAsia > recordNumberOfBordersOutsideAsia) {
                    countryWithMostBordersWithOutsideAsia = country;
                    recordNumberOfBordersOutsideAsia = numberOfBordersWithOutsideAsia;
                }
            }

            return countryWithMostBordersWithOutsideAsia;
        }

        public void printSortedCountriesByPopulationDensity(Order order) {
            List<Country> sortedCountries = this.sortByPopulationDensity(order);

            for (Country country : sortedCountries) {
                System.out.println(country.getName() + " " + country.getPopulationDensity());
            }
        }
}
