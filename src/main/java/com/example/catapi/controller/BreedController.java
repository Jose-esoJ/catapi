package com.example.catapi.controller;

import com.example.catapi.dto.BreedResponseDTO;
import com.example.catapi.service.BreedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/breeds")
public class BreedController {

    private final BreedService breedService;

    @GetMapping
    public ResponseEntity<List<BreedResponseDTO>> getAllBreeds() {
        return ResponseEntity.ok(breedService.getAllBreeds());
    }

    @GetMapping("/breedId")
    public ResponseEntity<BreedResponseDTO> getBreedById(@RequestParam(value = "breedId") String breedId) {
        return ResponseEntity.ok(breedService.getBreedById(breedId));
    }

    @GetMapping("/search")
    public ResponseEntity<List<BreedResponseDTO>> searchBreeds(@RequestParam(value = "query") String query) {
        return ResponseEntity.ok(breedService.searchBreeds(query));
    }
}
