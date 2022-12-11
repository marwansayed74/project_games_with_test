package com.example.project_games.controllers;

import com.example.project_games.controllers.RegistrationController;
import com.example.project_games.services.RegistrationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class RegistrationControllerTest {

    @Test
    void confirm() {
        RegistrationService registrationService= Mockito.mock(RegistrationService.class);
        when(registrationService.confirmToken("token")).thenReturn("token");
        RegistrationController registrationController=new RegistrationController(registrationService);
        assertEquals("token",registrationService.confirmToken("token"));
    }


    @Test
    void register() {
    }

    @Test
    void login() {
    }

}