package com.example.project_games.controllers;

import com.example.project_games.appuser.AppUserRepository;
import com.example.project_games.controllers.DiceScoreController;
import com.example.project_games.entitys.DiceScore;
import com.example.project_games.services.DiceScoreService;
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

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
@ExtendWith(MockitoExtension.class)
class DiceScoreControllerUrlTest {

    @Mock
    DiceScoreService diceScoreService;
    @InjectMocks
    DiceScoreController diceScoreController;
    @Mock
    AppUserRepository appUserRepository;
    @Mock
    AuthenticationManager authenticationManager;
    @Test
    void playDiceScore() {

        List<Integer> list=new ArrayList<>();
        list.add(4);
        list.add(4);
        list.add(4);
        list.add(3);
        list.add(3);
        DiceScore diceScore=new DiceScore(list);
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Authentication authentication = mock(Authentication.class);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        ResponseEntity<String> responseEntity = diceScoreController.playDiceScore(diceScore);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }
}