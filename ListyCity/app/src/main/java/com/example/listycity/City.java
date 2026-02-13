package com.example.listycity;

import java.util.Objects;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City> {
    private String city;
    private String province;
    /**
     * This is the constructor for the class City
     * @param city
     *   This is the name of the city
     * @param province
     *   This is the name of the province
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }
    /**
     * This returns the name of the city
     * @return
     *   Return the name of the city
     */
    String getCityName(){
        return this.city;
    }
    /**
     * This returns the name of the province
     * @return
     *   Return the name of the province
     */
    String getProvinceName(){
        return this.province;
    }
    /**
     * This compares two cities
     * @param o
     *   This is a candidate city to compare
     * @return
     *   Return 0 if the cities are the same, ~= 0 otherwise
     */
    @Override
    public int compareTo(City o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }
    /**
     * This determines if two cities are the same
     * @param o
     *   This is a candidate city to compare
     * @return
     *   Return true if the cities are the same, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city1 = (City) o;
        return city.equals(city1.city) && province.equals(city1.province);
    }
    /**
     * This returns the hash code of the city
     * @return
     *   Return the hash code of the city
     */
    @Override
    public int hashCode() {
        return city.hashCode() + province.hashCode();
    }
}
