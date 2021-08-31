package com.example.Airplane.services;

import com.example.Airplane.models.Airplane;
import com.example.Airplane.repositories.AirplaneRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class AirplaneServiceTest {

    @InjectMocks
    AirplaneService airplaneService;

    @Mock
    AirplaneRepository mockedAirplaneRepository;

    @Test
    void getAllAirplanesTest() {

        // Arrange
        Airplane testAirplane1 = new Airplane(5, "passenger", "xyz89", 4);
        Airplane testAirplane2 = new Airplane(6, "passenger", "xyz88", 3);

        List<Airplane> testAirplanes = new ArrayList<>();
        testAirplanes.add(testAirplane1);
        testAirplanes.add(testAirplane2);

        when(mockedAirplaneRepository.findAll()).thenReturn(testAirplanes);

        // Act
        List<Airplane> actualAirplanes = (List<Airplane>) airplaneService.getAllAirplanes();

        // Assert
        Assertions.assertEquals(testAirplanes.size(), actualAirplanes.size());
        Assertions.assertEquals(4, actualAirplanes.get(0).getFuel());

    }

    @Test
    void saveAirplaneSuccessTest() {

        // Arrange
        Airplane testAirplane = new Airplane(10, "passenger", "xyz79", 5);;

        when(mockedAirplaneRepository.save(testAirplane)).thenReturn(testAirplane);

        // Act
        Airplane actualAirplane = airplaneService.saveAirplane(testAirplane);

        // Assert
        Assertions.assertEquals(testAirplane.getId(), actualAirplane.getId());
        Assertions.assertEquals(testAirplane.getPlate(), actualAirplane.getPlate());
    }
}