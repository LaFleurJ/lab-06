package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Calgary", "Alberta");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }
    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Winnipeg", "Manitoba");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }
    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
    // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
    // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
    // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
    // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        // https://www.infoworld.com/article/3305792/comparing-java-objects-with-equals-and-hashcode.html
        // read given reference
        CityList cityList = mockCityList();
        assertTrue(cityList.hasCity(mockCity()));
        assertFalse(cityList.hasCity(new City("Winnipeg", "Manitoba")));
    }

    @Test
    void testRemoveCity() {
        CityList cityList = mockCityList(); // add edm
        assertEquals(1, cityList.countCities());
        cityList.removeCity(new City("Edmonton", "Alberta"));
        assertEquals(0, cityList.countCities());
    }

    @Test
    void testRemoveCityException() {
        CityList cityList = mockCityList();
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.removeCity(new City("Winnipeg", "Manitoba"));
        });
        assertEquals(1, cityList.countCities()); // no change listed
    }


    @Test
    void testCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
        cityList.add(new City("Vancouver", "British Columbia"));
        cityList.add(new City("Calgary", "Alberta"));
        assertEquals(3, cityList.countCities());
        cityList.removeCity(new City("Edmonton", "Alberta"));
        assertEquals(2, cityList.countCities());
    }

    @Test
    void testCountEmpty() {
        CityList cityList = new CityList();
        assertEquals(0, cityList.countCities());
    }

}
