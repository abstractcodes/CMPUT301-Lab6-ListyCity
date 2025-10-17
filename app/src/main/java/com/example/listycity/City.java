package com.example.listycity;

/**
 * This is a class that defines a City.
 * A city has a name and a province.
 *
 * @author Your Name
 * @version 1.0
 */
public class City implements Comparable<City> {

    /** The name of the city */
    private String city;

    /** The province where the city is located */
    private String province;

    /**
     * Constructor for City
     * @param city
     *        The name of the city
     * @param province
     *        The province where the city is located
     */
    City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * Gets the city name
     * @return
     *        The name of the city
     */
    String getCityName() {
        return this.city;
    }

    /**
     * Gets the province name
     * @return
     *        The name of the province
     */
    String getProvinceName() {
        return this.province;
    }

    /**
     * Compares this city with another city based on city names
     * @param o
     *        The city object to compare with
     * @return
     *        Negative integer if this city comes before the other,
     *        positive if after, zero if equal
     */
    @Override
    public int compareTo(City o) {
        return this.city.compareTo(o.getCityName());
    }

    /**
     * Checks if two City objects are equal based on city name and province
     * @param o
     *        The object to compare with
     * @return
     *        True if both city name and province match, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City otherCity = (City) o;
        return city.equals(otherCity.city) && province.equals(otherCity.province);
    }

    /**
     * Generates a hash code for the City object
     * @return
     *        Hash code based on city name and province
     */
    @Override
    public int hashCode() {
        return city.hashCode() + province.hashCode();
    }
}