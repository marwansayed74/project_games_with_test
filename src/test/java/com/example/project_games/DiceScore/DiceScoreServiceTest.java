package com.example.project_games.DiceScore;

import com.example.project_games.appuser.AppUser;
import com.example.project_games.appuser.AppUserRepository;
import com.example.project_games.appuser.AppUserRole;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DiceScoreServiceTest {
    @InjectMocks
    private DiceScoreService diceScoreService;

    @Mock
    private AppUserRepository appUserRepository;

    @Test
    void diceScore() {
        AppUser appUser=new AppUser();
        appUser.setFirstName("marwan");
        appUser.setLastName("sayed");
        appUser.setLocked(true);
        appUser.setEmail("marwan@gmail.com");
        appUser.setEnabled(true);
        appUser.setAppUserRole(AppUserRole.USER);
        appUser.setPassword("password");
        List<Integer> list=new ArrayList<>();
        list.add(4);
        list.add(4);
        list.add(4);
        list.add(3);
        list.add(3);
       DiceScore diceScore=new DiceScore();
       diceScore.setList(list);
        when(appUserRepository.findByLocked(true)).thenReturn(Optional.of(appUser));
        String real=diceScoreService.diceScore(diceScore);
        assertEquals("400",real);
    }
}