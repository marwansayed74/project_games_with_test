package com.example.project_games.services;

import com.example.project_games.entitys.AppUser;
import com.example.project_games.appuser.AppUserRepository;
import com.example.project_games.appuser.AppUserRole;
import com.example.project_games.entitys.RegistrationRequestDTO;
import com.example.project_games.registration.EmailValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RegistrationServiceTest {
    @InjectMocks
    private RegistrationService registrationService;
    @Mock
    private AppUserService appUserService ;

    @Mock
    private AppUserRepository appUserRepository;
    @Mock
    private  BCryptPasswordEncoder bCryptPasswordEncoder;
    @Mock
    private EmailValidator emailValidator;


    @Test
    void register() {
        //        given
        AppUser appUser=new AppUser("marwan","sayed","marwan@gmail.com","password",AppUserRole.USER);
        //      when
        when(emailValidator.test(appUser.getEmail())).thenReturn(true);
        when(appUserService.signUpUser(appUser)).thenReturn("token");

        String tokenreal= registrationService.register(
                new RegistrationRequestDTO("marwan","sayed","marwan@gmail.com","password"));
//        then
        assertEquals("token",tokenreal);
    }

    @Test
    void login() {
//        given
        AppUser appUser=new AppUser("marwan","sayed","marwan@gmail.com","password",AppUserRole.USER);
        appUser.setLocked(true);
        appUser.setEnabled(true);
        RegistrationRequestDTO registrationRequestDTO =new RegistrationRequestDTO();
        registrationRequestDTO.setEmail(appUser.getEmail());
        registrationRequestDTO.setPassword(appUser.getPassword());
        String expected="you are in";
//        when
        when(appUserRepository.findByEmail(appUser.getEmail())).thenReturn(Optional.of(appUser));
        when(bCryptPasswordEncoder.matches(registrationRequestDTO.getPassword(),appUser.getPassword())).thenReturn(true);
//        then
        assertEquals(expected,registrationService.login(registrationRequestDTO));
    }
}