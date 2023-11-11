import org.countries.*;
import org.countries.enums.Order;
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
    @Test
    public void testSortByPopulationDensity() {
        CountriesApplication countriesApplication = new CountriesApplication(countriesClient);
        countriesApplication.fetchAllCountries();

        List<Country> sortedByPopulationDensity = countriesApplication.sortByPopulationDensity(Order.DESCENDING);

        assertEquals("South Korea", sortedByPopulationDensity.get(0).getName());
        assertEquals("Turkey", sortedByPopulationDensity.get(1).getName());
        assertEquals("Germany", sortedByPopulationDensity.get(2).getName());
    }

    @Test
    public void testAsianCountryWithMostBorderingCountriesFromOutsideAsia() {
        CountriesApplication countriesApplication = new CountriesApplication(countriesClient);
        countriesApplication.fetchAllCountries();

        Country countryWithMostBordersOutsideAsia = countriesApplication.asianCountryWithMostBorderingCountriesFromOutsideAsia();

        assertEquals("Turkey", countryWithMostBordersOutsideAsia.getName());
    }

    @Before
    public void setUpCountries() {
        CountryName turkeyName = new CountryName();
        turkeyName.setCommon("Turkey");

        Country turkey = new Country();
        turkey.setPopulation(200);
        turkey.setArea(50);
        turkey.setRegion("Asia");
        turkey.setName(turkeyName);
        turkey.setCca3("TUR");
        turkey.setBorders(new ArrayList() {{
            add("ARM");
            add("AZE");
            add("BGR");
            add("GEO");
            add("GRC");
            add("IRN");
            add("IRQ");
            add("SYR");
        }});
        // dp of 4

        CountryName germanyName = new CountryName();
        germanyName.setCommon("Germany");
        Country germany = new Country();
        germany.setPopulation(300);
        germany.setArea(120);
        germany.setRegion("Europe");
        germany.setName(germanyName);
        germany.setCca3("DEU");
        germany.setBorders(new ArrayList() {{
            add("AUT");
            add("BEL");
            add("CZE");
            add("DNK");
            add("FRA");
            add("LUX");
            add("NLD");
            add("POL");
            add("CHE");
        }});
        // dp of 2.5

        CountryName southKoreaName = new CountryName();
        southKoreaName.setCommon("South Korea");
        Country southKorea = new Country();
        southKorea.setPopulation(1000);
        southKorea.setArea(200);
        southKorea.setRegion("Asia");
        southKorea.setName(southKoreaName);
        southKorea.setCca3("KOR");
        southKorea.setBorders(new ArrayList() {{
            add("PRK");
        }});
        // dp of 5

        List<Country> listOfCountries = new ArrayList<Country>();

        listOfCountries.add(turkey);
        listOfCountries.add(germany);
        listOfCountries.add(southKorea);

        Countries countries = new Countries();
        countries.setCountries(listOfCountries);

        when(countriesClient.getAllCountries()).thenReturn(countries);
    }
}
