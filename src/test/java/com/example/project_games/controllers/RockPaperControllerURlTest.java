package com.example.project_games.controllers;

import com.example.project_games.appuser.AppUserRepository;
import com.example.project_games.controllers.RockPaperController;
import com.example.project_games.entitys.RockPaper;
import com.example.project_games.services.RockPaperService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.assertj.core.api.Assertions.assertThat;

//@RunWith(SpringJUnit4ClassRunner.class)
//@AutoConfigureMockMvc
//@WebAppConfiguration
//@SpringBootTest(classes = RockPaperController.class)
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = RockPaperController.class)
//@ExtendWith(MockitoExtension.class)
@ExtendWith(MockitoExtension.class)
class RockPaperControllerURlTest {
    @Mock
    RockPaperService rockPaperService;
    @InjectMocks
    RockPaperController rockPaperController;
    @Mock
    AppUserRepository appUserRepository;
    @Mock
    AuthenticationManager authenticationManager;
    @Test
    void playRockController() throws Exception {

        RockPaper rock = new RockPaper("rock");
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Authentication authentication = mock(Authentication.class);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        ResponseEntity<String> responseEntity = rockPaperController.playRock(rock);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
//        MockHttpServletRequest request = new MockHttpServletRequest();
//        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
//        RockPaper rock = new RockPaper("rock");
//        rockPaperService.playRock(rock);
//        ResponseEntity<String> responseEntity = rockPaperController.playRock(rock);
//        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
//        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/play");


    }
}