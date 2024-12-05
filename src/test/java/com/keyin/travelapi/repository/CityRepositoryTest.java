package com.keyin.travelapi.repository;

import com.keyin.travelapi.model.City;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CityRepositoryTest {

    @Mock
    private CityRepository cityRepository;

    @Test
    public void testFindAll() {
        // Create a mock city
        City city = new City("Test City");

        // Mock the repository behavior
        when(cityRepository.findAll()).thenReturn(List.of(city));

        // Call the method
        List<City> result = cityRepository.findAll();

        // Assert the result
        assertEquals(1, result.size());
        assertEquals(city, result.get(0));
    }
}