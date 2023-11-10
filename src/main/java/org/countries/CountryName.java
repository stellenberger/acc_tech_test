package org.countries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryName {
    private String common;

    public String getCommon() {
        return this.common;
    }
}
