package com.keyin.travelapi.repository;

import com.keyin.travelapi.model.Airport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AirportRepositoryTest {

    @Mock
    private AirportRepository airportRepository;

    @Test
    public void testFindAll() {
        // Create a mock airport
        Airport airport = new Airport("Test Airport", "TST");

        // Mock the repository behavior
        when(airportRepository.findAll()).thenReturn(List.of(airport));

        // Call the method
        List<Airport> result = airportRepository.findAll();

        // Assert the result
        assertEquals(1, result.size());
        assertEquals(airport, result.get(0));
    }
}