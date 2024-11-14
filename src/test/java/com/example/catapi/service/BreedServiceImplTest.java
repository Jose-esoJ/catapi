package com.example.catapi.service;

import com.example.catapi.dto.BreedResponseDTO;
import com.example.catapi.service.Impl.BreedServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class BreedServiceImplTest {


    @InjectMocks
    private BreedServiceImpl breedService;

    @Test
    void test_GetAllBreeds() {
        ReflectionTestUtils.setField(breedService, "apiUrl", "https://api.thecatapi.com/v1");
        ReflectionTestUtils.setField(breedService, "apiKey", "live_JBT0Ah0Nt12iyl2IpjQVLDWjcLk0GQwf4zI9wBMfmfejKmcC31mOJp4yJz5TsOUP");

        List<BreedResponseDTO> result = breedService.getAllBreeds();

        assertEquals(67, result.size());
    }

    @Test
    void test_GetBreedById() {
        ReflectionTestUtils.setField(breedService, "apiUrl", "https://api.thecatapi.com/v1");
        ReflectionTestUtils.setField(breedService, "apiKey", "live_JBT0Ah0Nt12iyl2IpjQVLDWjcLk0GQwf4zI9wBMfmfejKmcC31mOJp4yJz5TsOUP");

        String breedId = "abys";

        BreedResponseDTO result = breedService.getBreedById(breedId);

        assertEquals(breedId, result.getId());
        assertEquals("Abyssinian", result.getName());
    }

    @Test
    void test_SearchBreeds() {
        ReflectionTestUtils.setField(breedService, "apiUrl", "https://api.thecatapi.com/v1");
        ReflectionTestUtils.setField(breedService, "apiKey", "live_JBT0Ah0Nt12iyl2IpjQVLDWjcLk0GQwf4zI9wBMfmfejKmcC31mOJp4yJz5TsOUP");

        String query = "Abyss";

        List<BreedResponseDTO> result = breedService.searchBreeds(query);

        assertEquals(1, result.size());
    }
}