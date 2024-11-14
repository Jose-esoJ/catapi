package com.example.catapi.controller;

import com.example.catapi.dto.BreedResponseDTO;
import com.example.catapi.service.BreedService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.assertj.core.api.Assertions.assertThat;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class BreedControllerTest {

    @Mock
    private BreedService breedService;

    @InjectMocks
    private BreedController breedController;


    @Test
    void test_GetAllBreeds() throws Exception {
        BreedResponseDTO breed1 = BreedResponseDTO.builder()
                .id("1")
                .name("Breed1")
                .build();
        BreedResponseDTO breed2 = BreedResponseDTO.builder()
                .id("2")
                .name("Breed2")
                .build();
        List<BreedResponseDTO> breeds = Arrays.asList(breed1, breed2);

        when(breedService.getAllBreeds()).thenReturn(breeds);

        ResponseEntity<List<BreedResponseDTO>> response = breedController.getAllBreeds();
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

    }

    @Test
    void test_GetBreedById() throws Exception {
        String breedId = "1";
        BreedResponseDTO breed = BreedResponseDTO.builder()
                .id("1")
                .name("Breed1")
                .build();
        when(breedService.getBreedById(breedId)).thenReturn(breed);

        ResponseEntity<BreedResponseDTO> response = breedController.getBreedById(breedId);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);


    }

    @Test
    void test_SearchBreeds() throws Exception {
        String query = "Breed";
        BreedResponseDTO breed1 = BreedResponseDTO.builder()
                .id("1")
                .name("Breed1")
                .build();
        BreedResponseDTO breed2 = BreedResponseDTO.builder()
                .id("2")
                .name("Breed2")
                .build();
        List<BreedResponseDTO> breeds = Arrays.asList(breed1, breed2);

        when(breedService.searchBreeds(query)).thenReturn(breeds);

        ResponseEntity<List<BreedResponseDTO>> response = breedController.searchBreeds(query);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}