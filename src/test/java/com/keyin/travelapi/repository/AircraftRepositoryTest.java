package com.keyin.travelapi.repository;

import com.keyin.travelapi.model.Aircraft;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AircraftRepositoryTest {

    @Mock
    private AircraftRepository aircraftRepository;

    @Test
    public void testFindByTypeAndAirlineName() {
        // Create a mock aircraft
        Aircraft aircraft = new Aircraft("Boeing 737", "Airline A");

        // Mock the repository behavior
        when(aircraftRepository.findByTypeAndAirlineName(anyString(), anyString())).thenReturn(List.of(aircraft));

        // Call the method
        List<Aircraft> result = aircraftRepository.findByTypeAndAirlineName("Boeing 737", "Airline A");

        // Assert the result
        assertEquals(1, result.size());
        assertEquals(aircraft, result.get(0));
    }
}