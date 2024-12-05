//package com.keyin.travelapi.service;
//
//import com.keyin.travelapi.model.City;
//import com.keyin.travelapi.repository.CityRepository;
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
//class CityServiceTest {
//
//    @Mock
//    private CityRepository cityRepository;
//
//    @InjectMocks
//    private CityService cityService;
//
//    private City testCity;
//
//    @BeforeEach
//    void setUp() {
//        testCity = new City();
//        testCity.setId(1L);
//        testCity.setName("San Francisco");
//        testCity.setState("CA");
//        testCity.setPopulation(874_961);
//    }
//
//    @Test
//    void shouldGetAllCities() {
//        when(cityRepository.findAll()).thenReturn(Arrays.asList(testCity));
//
//        List<City> result = cityService.getAllCities();
//
//        assertThat(result).hasSize(1);
//        assertThat(result.get(0).getId()).isEqualTo(1L);
//        assertThat(result.get(0).getName()).isEqualTo("San Francisco");
//        assertThat(result.get(0).getState()).isEqualTo("CA");
//        assertThat(result.get(0).getPopulation()).isEqualTo(874_961);
//        verify(cityRepository).findAll();
//    }
//
//    @Test
//    void shouldGetCityById_whenCityExists() {
//        when(cityRepository.findById(1L)).thenReturn(Optional.of(testCity));
//
//        Optional<City> result = cityService.getCityById(1L);
//
//        assertThat(result).isPresent();
//        assertThat(result.get().getId()).isEqualTo(1L);
//        assertThat(result.get().getName()).isEqualTo("San Francisco");
//        assertThat(result.get().getState()).isEqualTo("CA");
//        assertThat(result.get().getPopulation()).isEqualTo(874_961);
//        verify(cityRepository).findById(1L);
//    }
//
//    @Test
//    void shouldGetCityById_whenCityDoesNotExist() {
//        when(cityRepository.findById(1L)).thenReturn(Optional.empty());
//
//        Optional<City> result = cityService.getCityById(1L);
//
//        assertThat(result).isNotPresent();
//        verify(cityRepository).findById(1L);
//    }
//
//    @Test
//    void shouldSaveCity() {
//        when(cityRepository.save(any(City.class))).thenReturn(testCity);
//
//        City savedCity = cityService.saveCity(testCity);
//
//        assertThat(savedCity).isNotNull();
//        assertThat(savedCity.getId()).isEqualTo(1L);
//        assertThat(savedCity.getName()).isEqualTo("San Francisco");
//        assertThat(savedCity.getState()).isEqualTo("CA");
//        assertThat(savedCity.getPopulation()).isEqualTo(874_961);
//        verify(cityRepository).save(testCity);
//    }
//
//    @Test
//    void shouldDeleteCity() {
//        doNothing().when(cityRepository).deleteById(1L);
//
//        cityService.deleteCity(1L);
//
//        verify(cityRepository).deleteById(1L);
//    }
//}




package com.keyin.travelapi.service;

import com.keyin.travelapi.model.City;
import com.keyin.travelapi.repository.CityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CityServiceTest {

    @Mock
    private CityRepository cityRepository;

    @InjectMocks
    private CityService cityService;

    private City testCity;

    @BeforeEach
    void setUp() {
        testCity = new City("Test City");
        testCity.setId(1L);
        testCity.setName("San Francisco");
        testCity.setState("CA");
        testCity.setPopulation(874_961);
    }

    @Test
    void shouldGetAllCities() {
        when(cityRepository.findAll()).thenReturn(Arrays.asList(testCity));

        List<City> result = cityService.getAllCities();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getId()).isEqualTo(1L);
        assertThat(result.get(0).getName()).isEqualTo("San Francisco");
        assertThat(result.get(0).getState()).isEqualTo("CA");
        assertThat(result.get(0).getPopulation()).isEqualTo(874_961);
        verify(cityRepository).findAll();
    }

    @Test
    void shouldGetCityById_whenCityExists() {
        when(cityRepository.findById(1L)).thenReturn(Optional.of(testCity));

        Optional<City> result = cityService.getCityById(1L);

        assertThat(result).isPresent();
        assertThat(result.get().getId()).isEqualTo(1L);
        assertThat(result.get().getName()).isEqualTo("San Francisco");
        assertThat(result.get().getState()).isEqualTo("CA");
        assertThat(result.get().getPopulation()).isEqualTo(874_961);
        verify(cityRepository).findById(1L);
    }

    @Test
    void shouldGetCityById_whenCityDoesNotExist() {
        when(cityRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<City> result = cityService.getCityById(1L);

        assertThat(result).isNotPresent();
        verify(cityRepository).findById(1L);
    }

    @Test
    void shouldSaveCity() {
        when(cityRepository.save(any(City.class))).thenReturn(testCity);

        City savedCity = cityService.saveCity(testCity);

        assertThat(savedCity).isNotNull();
        assertThat(savedCity.getId()).isEqualTo(1L);
        assertThat(savedCity.getName()).isEqualTo("San Francisco");
        assertThat(savedCity.getState()).isEqualTo("CA");
        assertThat(savedCity.getPopulation()).isEqualTo(874_961);
        verify(cityRepository).save(testCity);
    }

    @Test
    void shouldDeleteCity() {
        doNothing().when(cityRepository).deleteById(1L);

        cityService.deleteCity(1L);

        verify(cityRepository).deleteById(1L);
    }
}