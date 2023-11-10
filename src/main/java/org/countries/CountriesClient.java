package org.countries;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.countries.*;

public class CountriesClient {
    public Countries get(String apiUrl) {
        try {
            URL url = new URL(apiUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            connection.disconnect();

            Countries countries = new Countries();

            countries.setCountries(
                    new ObjectMapper()
                            .readValue(
                                    response.toString(),
                                    new TypeReference<List<Country>>() {})
            );

            return countries;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
