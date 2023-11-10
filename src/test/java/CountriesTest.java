import org.countries.Countries;
import org.countries.Country;
import org.countries.enums.Order;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CountriesTest {
    private List<Country> listOfCountries = new ArrayList<Country>();

    private Country country1 = new Country();
    private Country country2 = new Country();
    private Country country3 = new Country();

    @Test
    public void testGetCountries() {
        Countries countries = new Countries();
        countries.setCountries(listOfCountries);

        assertEquals(listOfCountries, countries.getCountries());
    }

    @Test
    public void testSortByPopulationDensity() {
        Countries countries = new Countries();
        countries.setCountries(listOfCountries);

        List<Country> sortedCountriesByPopulationDensityDescending = countries.sortByPopulationDensity(Order.DESCENDING);

        assertEquals(country3, sortedCountriesByPopulationDensityDescending.get(0));
        assertEquals(country1, sortedCountriesByPopulationDensityDescending.get(1));
        assertEquals(country2, sortedCountriesByPopulationDensityDescending.get(2));

        List<Country> sortedCountriesByPopulationDensityAscending = countries.sortByPopulationDensity(Order.ASCENDING);

        assertEquals(country2, sortedCountriesByPopulationDensityAscending.get(0));
        assertEquals(country1, sortedCountriesByPopulationDensityAscending.get(1));
        assertEquals(country3, sortedCountriesByPopulationDensityAscending.get(2));
    }

    @Before
    public void setUpCountries() {
        country1.setPopulation(200);
        country1.setArea(50);
        // dp of 4

        country2.setPopulation(300);
        country2.setArea(120);
        // dp of 2.5

        country3.setPopulation(1000);
        country3.setArea(200);
        // dp of 5

        listOfCountries.add(country1);
        listOfCountries.add(country2);
        listOfCountries.add(country3);
    }
}
