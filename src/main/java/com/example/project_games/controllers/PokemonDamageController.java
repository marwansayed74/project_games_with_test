package com.example.project_games.controllers;

import com.example.project_games.entitys.PokemonDamage;
import com.example.project_games.services.PokemonDamageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/registration")
public class PokemonDamageController {
    private final PokemonDamageService pokemonDamageService;

    public PokemonDamageController(PokemonDamageService pokemonDamageService) {
        this.pokemonDamageService = pokemonDamageService;
    }
    @PostMapping(path = "pokemonDamage")
    public ResponseEntity<String> pokemonDamage(@RequestBody PokemonDamage pokemon) {
        pokemonDamageService.pokemonDamage(pokemon);
        return new ResponseEntity<>("play done", HttpStatus.OK);
    }
}
