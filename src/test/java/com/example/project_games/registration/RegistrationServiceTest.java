package com.example.project_games.registration;

import com.example.project_games.appuser.AppUser;
import com.example.project_games.appuser.AppUserRepository;
import com.example.project_games.appuser.AppUserRole;
import com.example.project_games.appuser.AppUserService;
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
        AppUser appUser =new AppUser();
        appUser.setFirstName("marwan");
        appUser.setLastName("sayed");
        appUser.setEmail("marwan@gmail.com");
        appUser.setPassword("password");
        appUser.setAppUserRole(AppUserRole.USER);

        //      when
        when(emailValidator.test(appUser.getEmail())).thenReturn(true);
        when(appUserService.signUpUser(appUser)).thenReturn("token");

        String tokenreal= registrationService.register(
                new RegistrationRequest("marwan","sayed","marwan@gmail.com","password"));
//        then
        assertEquals("token",tokenreal);
    }

    @Test
    void login() {
//        given
        AppUser appUser =new AppUser();
        appUser.setEmail("marwan@gmail.com");
        appUser.setPassword("password");
        appUser.setEnabled(true);
        LoginResponse loginResponse = new LoginResponse(appUser.getEmail(), appUser.getPassword());
        String ss="you are in";
//        when
        when(appUserRepository.findByEmail(appUser.getEmail())).thenReturn(Optional.of(appUser));
        when(bCryptPasswordEncoder.matches(loginResponse.getPassword(),appUser.getPassword())).thenReturn(true);
//        then
        String ss2 =registrationService.login(loginResponse);
        assertEquals(ss,ss2);
    }
}