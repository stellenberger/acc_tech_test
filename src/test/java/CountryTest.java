import org.countries.Country;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountryTest {
    @Test
    public void testGetPopulationDensity() {
        Country country = new Country();
        country.setPopulation(500);
        country.setArea(200);

        assertEquals(2.5, country.getPopulationDensity(), 0.0);
    }
}
