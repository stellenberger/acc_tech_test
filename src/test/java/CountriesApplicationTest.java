import org.countries.Countries;
import org.countries.CountriesApplication;
import org.countries.CountriesClient;
import org.countries.Country;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CountriesApplicationTest {
    @Mock
    CountriesClient countriesClient;

    public CountriesApplicationTest() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testGetAllCountries() {
        CountriesApplication countriesApplication = new CountriesApplication(countriesClient);
        countriesApplication.fetchAllCountries();

        Countries countries = countriesApplication.getCountries();

        assertEquals(3, countries.getCountries().size());
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

        List<Country> listOfCountries = new ArrayList<Country>();

        listOfCountries.add(country1);
        listOfCountries.add(country2);
        listOfCountries.add(country3);

        Countries countries = new Countries();
        countries.setCountries(listOfCountries);

        when(countriesClient.getAllCountries()).thenReturn(countries);
    }
}
