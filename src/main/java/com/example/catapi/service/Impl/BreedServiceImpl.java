package com.example.catapi.service.Impl;

import com.example.catapi.dto.BreedResponseDTO;
import com.example.catapi.service.BreedService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BreedServiceImpl implements BreedService {

    @Value("${catapi.base-url}")
    private String apiUrl;

    @Value("${catapi.api-key}")
    private String apiKey;


    public List<BreedResponseDTO> getAllBreeds() {
        return Arrays.asList(fetchFromCatApi("/breeds","", BreedResponseDTO[].class));
    }

    public BreedResponseDTO getBreedById(String breedId) {
        return fetchFromCatApi("/breeds/" + breedId, "",BreedResponseDTO.class);
    }

    public List<BreedResponseDTO> searchBreeds(String query) {
        return Arrays.asList(fetchFromCatApi("/breeds/search" , query, BreedResponseDTO[].class));
    }

    // Método solicitudes GET
    private <T> T fetchFromCatApi(String endpoint, String param, Class<T> responseType) {
        RestTemplate restTemplate = new RestTemplate();
        String url = buildUrl(endpoint, param);
        return restTemplate.getForObject(url, responseType);
    }

    private String buildUrl(String endpoint, String param) {

        return  (param.isEmpty()) ?
                    UriComponentsBuilder.fromHttpUrl(apiUrl)
                    .path(endpoint)
                    .queryParam("api_key", apiKey)
                    .toUriString()
                :UriComponentsBuilder.fromHttpUrl(apiUrl)
                    .path(endpoint)
                    .queryParam("q", param)
                    .queryParam("api_key", apiKey)
                    .toUriString();
    }


}
