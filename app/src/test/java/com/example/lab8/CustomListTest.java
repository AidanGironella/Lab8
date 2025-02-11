package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    public CustomList MockCityList() {
        list = new CustomList(null, new ArrayList<>());
        return list;
    }
    @Test
    public void addCityTest() {
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), listSize+1);
    }

    @Test
    public void hasCityTest() {
        list = MockCityList();
        City cityShouldExist = new City("Edmonton", "Alberta");
        list.addCity(cityShouldExist);
        assertTrue(list.hasCity(cityShouldExist));
        City cityShouldNotExist = new City("Calgary", "Alberta");
        assertFalse(list.hasCity(cityShouldNotExist));
    }

    @Test
    public void deleteCityTest() {
        list = MockCityList();
        City city = new City("Edmonton", "Alberta");
        assertThrows(IllegalArgumentException.class, () -> list.deleteCity(city));
        list.addCity(city);
        list.deleteCity(city);
        assertFalse(list.hasCity(city));
    }

    @Test
    public void countCitiesTest() {
        list = MockCityList();
        int listSize = list.getCount();
        assertEquals(list.countCities(), listSize);
        list.addCity(new City("Edmonton", "Alberta"));
        assertEquals(list.countCities(), listSize+1);
        list.addCity(new City("Calgary", "Alberta"));
        assertEquals(list.countCities(), listSize+2);
    }
}
