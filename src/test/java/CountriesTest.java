import org.countries.Countries;
import org.countries.Country;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CountriesTest {
    private List<Country> listOfCountries = new ArrayList<Country>();
    @Test
    public void testGetCountries() {
        Countries countries = new Countries();
        countries.setCountries(listOfCountries);

        assertEquals(listOfCountries, countries.getCountries());
    }

    @Before
    public void setUpCountries() {
        Country country1 = new Country();
        country1.setPopulation(200);
        country1.setArea(50);

        Country country2 = new Country();
        country2.setPopulation(300);
        country2.setArea(120);

        Country country3 = new Country();
        country3.setPopulation(1000);
        country3.setArea(200);

        listOfCountries.add(country1);
        listOfCountries.add(country2);
        listOfCountries.add(country3);
    }
}
