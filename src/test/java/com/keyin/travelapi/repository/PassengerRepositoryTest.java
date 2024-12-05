package com.keyin.travelapi.repository;

import com.keyin.travelapi.model.Passenger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PassengerRepositoryTest {

    @Mock
    private PassengerRepository passengerRepository;

    @Test
    public void testFindAll() {
        // Create a mock passenger
        Passenger passenger = new Passenger("John Doe", "johndoe@example.com");

        // Mock the repository behavior
        when(passengerRepository.findAll()).thenReturn(List.of(passenger));

        // Call the method
        List<Passenger> result = passengerRepository.findAll();

        // Assert the result
        assertEquals(1, result.size());
        assertEquals(passenger, result.get(0));
    }
}