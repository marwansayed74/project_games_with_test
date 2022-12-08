package com.example.project_games.registration;

import com.example.project_games.rockPaper.RockPaper;
import com.example.project_games.rockPaper.RockPaperController;
import com.example.project_games.rockPaper.RockPaperService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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