package org.countries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {
    private String cca2;

    public String getCca2() {
        return cca2;
    }
}
