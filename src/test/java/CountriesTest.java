import org.countries.Countries;
import org.countries.Country;
import org.countries.CountryName;
import org.countries.enums.Order;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CountriesTest {
    private List<Country> listOfCountries = new ArrayList<Country>();

    private Country turkey = new Country();
    private Country germany = new Country();
    private Country southKorea = new Country();

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

        assertEquals(southKorea, sortedCountriesByPopulationDensityDescending.get(0));
        assertEquals(turkey, sortedCountriesByPopulationDensityDescending.get(1));
        assertEquals(germany, sortedCountriesByPopulationDensityDescending.get(2));

        List<Country> sortedCountriesByPopulationDensityAscending = countries.sortByPopulationDensity(Order.ASCENDING);

        assertEquals(germany, sortedCountriesByPopulationDensityAscending.get(0));
        assertEquals(turkey, sortedCountriesByPopulationDensityAscending.get(1));
        assertEquals(southKorea, sortedCountriesByPopulationDensityAscending.get(2));
    }

    @Test
    public void testGetAllAsianCca3() {
        Countries countries = new Countries();
        countries.setCountries(listOfCountries);

        List<String> asianCca3 = countries.getAllAsianCca3();

        assertEquals(2, asianCca3.size());
        assertEquals("TUR", asianCca3.get(0));
        assertEquals("KOR", asianCca3.get(1));
    }

    @Test
    public void testGetAllAsianCountries() {
        Countries countries = new Countries();
        countries.setCountries(listOfCountries);

        List<Country> asianCountries = new ArrayList() {{
            add(turkey);
            add(southKorea);
        }};

        assertEquals(asianCountries, countries.getAsianCountries());
    }


    @Before
    public void setUpCountries() {
        CountryName turkeyName = new CountryName();
        turkeyName.setCommon("Turkey");
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
        southKorea.setPopulation(1000);
        southKorea.setArea(200);
        southKorea.setRegion("Asia");
        southKorea.setName(southKoreaName);
        southKorea.setCca3("KOR");
        southKorea.setBorders(new ArrayList() {{
            add("PRK");
        }});
        // dp of 5

        listOfCountries.add(turkey);
        listOfCountries.add(germany);
        listOfCountries.add(southKorea);
    }
}
