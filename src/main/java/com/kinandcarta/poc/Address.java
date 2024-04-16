package com.kinandcarta.poc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class Address {

    private static final Logger log = LoggerFactory.getLogger(Address.class);

    private String city;
    private String state;
    private int zipcode;

    public Address(String city, String state, int zipcode) {
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZipcode() {
        return zipcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address address)) return false;
        return zipcode == address.zipcode && Objects.equals(city, address.city) && Objects.equals(state, address.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, state, zipcode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "state='" + state + '\'' +
                ", zipcode=" + zipcode +
                ", city='" + city + '\'' +
                '}';
    }
}
