package com.example.project_games.PokemonDamage;

import com.example.project_games.rockPaper.RockPaper;
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
    public String pokemonDamage(@RequestBody PokemonDamage pokemon) {
        return pokemonDamageService.pokemonDamage(pokemon);
    }
}
