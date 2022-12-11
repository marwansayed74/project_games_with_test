package com.example.project_games.controllers;

import com.example.project_games.appuser.AppUserRepository;
import com.example.project_games.controllers.PokemonDamageController;
import com.example.project_games.entitys.PokemonDamage;
import com.example.project_games.services.PokemonDamageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
@ExtendWith(MockitoExtension.class)
class PokemonDamageControllerURLTest {
    @Mock
    PokemonDamageService pokemonDamageService;
    @InjectMocks
    PokemonDamageController pokemonDamageController;
    @Mock
    AppUserRepository appUserRepository;
    @Mock
    AuthenticationManager authenticationManager;
    @Test
    void pokemonDamage() {
        PokemonDamage pokemonDamage=new PokemonDamage("electric","fire",100,100);
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Authentication authentication = mock(Authentication.class);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        ResponseEntity<String> responseEntity = pokemonDamageController.pokemonDamage(pokemonDamage);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }
}