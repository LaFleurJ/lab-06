package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     *   This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     *   Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }
    /**
     * This checks if a city is in the list when given a city
     * @param city
     *   This is a candidate city to check
     * @return
     *   Return true if the city is in the list
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }
    /**
     * This checks if a city is present in the list. If it is then remove it from the list, if not it throws an execption
     * @param city
     *   This is a candidate city to remove
     *   @throws
     *   IllegalArgumentException if the city is not in the list
     */
    public void removeCity(City city) {
        if (cities.contains(city)) {
            cities.remove(city);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This returns how many cities are in the list.
     * @return
     *   Return the number of cities in the list
     */
    public int countCities() {
        return cities.size();
    }
}

