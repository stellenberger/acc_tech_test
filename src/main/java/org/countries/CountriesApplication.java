package org.countries;

public class CountriesApplication {
        CountriesClient countriesClient;
        Countries countries;

        public CountriesApplication(CountriesClient countriesClient) {
            this.countriesClient = countriesClient;
        }

        public void fetchAllCountries() {
            this.countries = this.countriesClient.getAllCountries();
        }
}
