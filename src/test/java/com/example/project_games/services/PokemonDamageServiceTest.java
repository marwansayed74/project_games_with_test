package com.example.project_games.services;

import com.example.project_games.entitys.AppUser;
import com.example.project_games.appuser.AppUserRepository;
import com.example.project_games.appuser.AppUserRole;
import com.example.project_games.entitys.PokemonDamage;
import com.example.project_games.services.PokemonDamageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyMapOf;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PokemonDamageServiceTest {

    @InjectMocks
    private PokemonDamageService pokemonDamageService;

    @Mock
    private AppUserRepository appUserRepository;

    @Test
    void pokemonDamage() {

        AppUser appUser=new AppUser("marwan","sayed","marwan@gmail.com","password",AppUserRole.USER);
        appUser.setLocked(true);
        appUser.setEnabled(true);
        PokemonDamage pokemonDamage=new PokemonDamage("fire","water",100,100);
        when(appUserRepository.findByLocked(true)).thenReturn(Optional.of(appUser));
        assertEquals("25.0",pokemonDamageService.pokemonDamage(pokemonDamage));

    }
}