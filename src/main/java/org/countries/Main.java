package org.countries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        CountriesClient client = new CountriesClient();

        client.get("https://restcountries.com/v3.1/all");
    }
}