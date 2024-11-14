package com.example.catapi.service;

import com.example.catapi.dto.BreedResponseDTO;

import java.util.List;

public interface BreedService {
    List<BreedResponseDTO> getAllBreeds();

    BreedResponseDTO getBreedById(String breedId);

    List<BreedResponseDTO> searchBreeds(String query);
}
