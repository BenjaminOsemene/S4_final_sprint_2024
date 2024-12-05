//package com.keyin.travelapi.service;
//
//import com.keyin.travelapi.model.Aircraft;
//import com.keyin.travelapi.repository.AircraftRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//class AircraftServiceTest {
//
//    @Mock
//    private AircraftRepository aircraftRepository;
//
//    @InjectMocks
//    private AircraftService aircraftService;
//
//    private Aircraft testAircraft;
//
//    @BeforeEach
//    void setUp() {
//        testAircraft = new Aircraft();
//        testAircraft.setId(1L);
//        testAircraft.setType("Boeing 747");
//        testAircraft.setAirlineName("Test Airline");
//        testAircraft.setNumberOfPassengers(366);
//    }
//
//    @Test
//    void getAllAircraft_shouldReturnListOfAircraft() {
//        when(aircraftRepository.findAll()).thenReturn(Arrays.asList(testAircraft));
//
//        List<Aircraft> result = aircraftService.getAllAircraft();
//
//        assertThat(result).hasSize(1);
//        assertThat(result.get(0).getId()).isEqualTo(1L);
//        assertThat(result.get(0).getType()).isEqualTo("Boeing 747");
//        assertThat(result.get(0).getAirlineName()).isEqualTo("Test Airline");
//        assertThat(result.get(0).getNumberOfPassengers()).isEqualTo(366);
//        verify(aircraftRepository).findAll();
//    }
//
//    @Test
//    void getAircraftById_shouldReturnAircraft_whenAircraftExists() {
//        when(aircraftRepository.findById(1L)).thenReturn(Optional.of(testAircraft));
//
//        Optional<Aircraft> result = aircraftService.getAircraftById(1L);
//
//        assertThat(result).isPresent();
//        assertThat(result.get().getId()).isEqualTo(1L);
//        assertThat(result.get().getType()).isEqualTo("Boeing 747");
//        assertThat(result.get().getAirlineName()).isEqualTo("Test Airline");
//        assertThat(result.get().getNumberOfPassengers()).isEqualTo(366);
//        verify(aircraftRepository).findById(1L);
//    }
//
//    @Test
//    void getAircraftById_shouldReturnEmptyOptional_whenAircraftDoesNotExist() {
//        when(aircraftRepository.findById(1L)).thenReturn(Optional.empty());
//
//        Optional<Aircraft> result = aircraftService.getAircraftById(1L);
//
//        assertThat(result).isNotPresent();
//        verify(aircraftRepository).findById(1L);
//    }
//
//    @Test
//    void saveAircraft_shouldReturnSavedAircraft() {
//        when(aircraftRepository.save(any(Aircraft.class))).thenReturn(testAircraft);
//
//        Aircraft result = aircraftService.saveAircraft(testAircraft);
//
//        assertThat(result.getId()).isEqualTo(1L);
//        assertThat(result.getType()).isEqualTo("Boeing 747");
//        assertThat(result.getAirlineName()).isEqualTo("Test Airline");
//        assertThat(result.getNumberOfPassengers()).isEqualTo(366);
//        verify(aircraftRepository).save(testAircraft);
//    }
//
//    @Test
//    void deleteAircraft_shouldCallRepositoryDeleteMethod() {
//        aircraftService.deleteAircraft(1L);
//
//        verify(aircraftRepository).deleteById(1L);
//    }
//}



package com.keyin.travelapi.service;

import com.keyin.travelapi.model.Aircraft;
import com.keyin.travelapi.repository.AircraftRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class AircraftServiceTest {

    @Mock
    private AircraftRepository aircraftRepository;

    @InjectMocks
    private AircraftService aircraftService;

    private Aircraft testAircraft;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testAircraft = new Aircraft();
        testAircraft.setId(1L);
        testAircraft.setType("Boeing 747");
        testAircraft.setAirlineName("Test Airline");
        testAircraft.setNumberOfPassengers(366);
    }

    @Test
    void getAllAircraft_shouldReturnListOfAircraft() {
        when(aircraftRepository.findAll()).thenReturn(Arrays.asList(testAircraft));

        List<Aircraft> result = aircraftService.getAllAircraft();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getType()).isEqualTo("Boeing 747");
        verify(aircraftRepository).findAll();
    }

    @Test
    void getAircraftById_shouldReturnAircraft_whenAircraftExists() {
        when(aircraftRepository.findById(1L)).thenReturn(Optional.of(testAircraft));

        Optional<Aircraft> result = aircraftService.getAircraftById(1L);

        assertThat(result).isPresent();
        assertThat(result.get().getType()).isEqualTo("Boeing 747");
        verify(aircraftRepository).findById(1L);
    }

    @Test
    void saveAircraft_shouldReturnSavedAircraft() {
        when(aircraftRepository.save(any(Aircraft.class))).thenReturn(testAircraft);

        Aircraft result = aircraftService.saveAircraft(testAircraft);

        assertThat(result.getType()).isEqualTo("Boeing 747");
        verify(aircraftRepository).save(testAircraft);
    }

    @Test
    void deleteAircraft_shouldCallRepositoryDeleteMethod() {
        aircraftService.deleteAircraft(1L);

        verify(aircraftRepository).deleteById(1L);
    }
}