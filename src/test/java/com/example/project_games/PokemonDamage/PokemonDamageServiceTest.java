package com.example.project_games.PokemonDamage;

import com.example.project_games.appuser.AppUser;
import com.example.project_games.appuser.AppUserRepository;
import com.example.project_games.appuser.AppUserRole;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PokemonDamageServiceTest {

    @InjectMocks
    private PokemonDamageService pokemonDamageService;

    @Mock
    private AppUserRepository appUserRepository;

    @Test
    void pokemonDamage() {

        AppUser appUser=new AppUser();
        appUser.setFirstName("marwan");
        appUser.setLastName("sayed");
        appUser.setLocked(true);
        appUser.setEmail("marwan@gmail.com");
        appUser.setEnabled(true);
        appUser.setAppUserRole(AppUserRole.USER);
        appUser.setPassword("password");
        PokemonDamage pokemonDamage=new PokemonDamage("fire","water",100,100);
        when(appUserRepository.findByLocked(true)).thenReturn(Optional.of(appUser));
        String real =pokemonDamageService.pokemonDamage(pokemonDamage);
        assertEquals("25.0",real);

    }
}