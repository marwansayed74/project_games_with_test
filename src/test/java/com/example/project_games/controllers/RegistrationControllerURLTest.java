package com.example.project_games.controllers;

import com.example.project_games.appuser.AppUserRepository;
import com.example.project_games.entitys.LoginResponse;
import com.example.project_games.entitys.RegistrationRequest;
import com.example.project_games.security.PasswordEncoder;
import com.example.project_games.services.RegistrationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;


@ExtendWith(MockitoExtension.class)
class RegistrationControllerURLTest {

    @Mock
    AppUserRepository appUserRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @InjectMocks
    RegistrationController registrationController;
    @Mock
    RegistrationService registrationService;

    @Test
    public void loginUrltest() throws Exception {
        LoginResponse loginResponse=new LoginResponse("marwangmail.com","password");
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Authentication authentication = mock(Authentication.class);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        ResponseEntity<String> responseEntity = registrationController.login(loginResponse);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void registerUrltest() throws Exception {
        RegistrationRequest registrationRequest =new RegistrationRequest("marwan","sayed","marwangmail.com","password");
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Authentication authentication = mock(Authentication.class);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        ResponseEntity<String> responseEntity = registrationController.register(registrationRequest);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
    }
    @Test
    void confirmUrltest() throws Exception {
        String ss="token";
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Authentication authentication = mock(Authentication.class);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        ResponseEntity<String> responseEntity = registrationController.confirm(ss);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

}