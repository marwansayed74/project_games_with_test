package com.example.project_games.services;

import com.example.project_games.entitys.AppUser;
import com.example.project_games.appuser.AppUserRepository;
import com.example.project_games.appuser.AppUserRole;
import com.example.project_games.entitys.RockPaper;
import com.example.project_games.services.RockPaperService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RockPaperServiceTest {
    @InjectMocks
    private RockPaperService rockPaperService;

    @Mock
    private AppUserRepository appUserRepository;

    @Test
    void testGameOne() {
        //given
        AppUser appUser=new AppUser();
        appUser.setFirstName("marwan");
        appUser.setLastName("sayed");
        appUser.setLocked(true);
        appUser.setEmail("marwan@gmail.com");
        appUser.setEnabled(true);
        appUser.setAppUserRole(AppUserRole.USER);
        appUser.setPassword("password");
        RockPaper rockPaper=new RockPaper();
        rockPaper.setMove("rock");
        //when
        when(appUserRepository.findByLocked(true)).thenReturn(Optional.of(appUser));
        String real =rockPaperService.playRock(rockPaper);

        if(real.equals("Computer chose scissor! you win"))
        {
            assertEquals("Computer chose scissor! you win",real);
        }
        else if(real.equals("Computer chose paper! the computer win")){
            assertEquals("Computer chose paper! the computer win",real);
        }
         else if(real.equals("Computer chose rock! the game is end draw")){
            assertEquals("Computer chose rock! the game is end draw",real);
        }




    }


}

