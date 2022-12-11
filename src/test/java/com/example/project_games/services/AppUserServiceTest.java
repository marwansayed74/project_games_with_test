package com.example.project_games.services;

import com.example.project_games.appuser.AppUserRepository;
import com.example.project_games.entitys.AppUser;
import com.example.project_games.registration.token.ConfirmationTokenService;
import com.example.project_games.services.AppUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AppUserServiceTest {
    @InjectMocks
    private AppUserService appUserService ;

    @Mock
    private AppUserRepository appUserRepository;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Mock
    private ConfirmationTokenService confirmationTokenService;


    @Test
    void loadUserByUsername() {
    //given

    AppUser appUser=new AppUser();
    String ss="ss@gmail.com";
    appUser.setEmail(ss);
    //when
    when(appUserRepository.findByEmail(appUser.getEmail())).thenReturn(Optional.of(appUser));
    AppUser appUser1 =appUserService.loadUserByUsername(ss);
    //given
    assertEquals(appUser,appUser1);

    }

    @Test
    void signUpUser() {
        //given
        AppUser appUser=new AppUser();
        appUser.setFirstName("marwan");
        appUser.setLastName("sayed");
        appUser.setEmail("marwan@gmail.com");
        appUser.setPassword("password");
        //when
        when(bCryptPasswordEncoder.encode(appUser.getPassword())).thenReturn("1qqqqqs");
        appUserService.signUpUser(appUser);
        ArgumentCaptor<AppUser> appUserArgumentCaptor =ArgumentCaptor.forClass(AppUser.class);
        verify(appUserRepository).save(appUserArgumentCaptor.capture());
        AppUser capturedAppUser=appUserArgumentCaptor.getValue();
        assertThat(capturedAppUser).isEqualTo(appUser);
    }

}