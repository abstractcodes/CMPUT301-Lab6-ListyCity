package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for CityList
 */
class CityListTest {

    /**
     * Creates a mock CityList with one city
     * @return
     *        CityList with Edmonton, Alberta
     */
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    /**
     * Creates a mock City object
     * @return
     *        City object for Edmonton, Alberta
     */
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
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
        CityList cityList = mockCityList();

        // Test that the mock city exists
        assertTrue(cityList.hasCity(mockCity()));

        // Test that a different city does not exist
        City newCity = new City("Calgary", "Alberta");
        assertFalse(cityList.hasCity(newCity));

        // Add the new city and verify it now exists
        cityList.add(newCity);
        assertTrue(cityList.hasCity(newCity));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();

        // Add a city to delete
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);

        // Verify the city is in the list
        assertEquals(2, cityList.countCities());
        assertTrue(cityList.hasCity(city));

        // Delete the city
        cityList.delete(city);

        // Verify the city was removed
        assertEquals(1, cityList.countCities());
        assertFalse(cityList.hasCity(city));
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        City city = new City("Vancouver", "British Columbia");

        // Test that exception is thrown when deleting a city that doesn't exist
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

    @Test
    void testCountCities() {
        CityList cityList = new CityList();

        // Initially empty
        assertEquals(0, cityList.countCities());

        // Add one city
        cityList.add(mockCity());
        assertEquals(1, cityList.countCities());

        // Add another city
        City city2 = new City("Toronto", "Ontario");
        cityList.add(city2);
        assertEquals(2, cityList.countCities());

        // Delete a city
        cityList.delete(city2);
        assertEquals(1, cityList.countCities());
    }
}