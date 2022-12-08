package com.example.project_games.rockPaper;

import com.example.project_games.appuser.AppUser;
import com.example.project_games.appuser.AppUserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class RockPaperControllerTest {
    @InjectMocks
    private RockPaperController rockPaperController;
    @Mock
    private RockPaperService rockPaperService;
    @Mock
    private RockPaper rockPaper;
    @Mock
    private AppUserRepository appUserRepository;
    @Mock
    private AppUser appUser;
    @Test
    void playRock() {
//        rockPaper =new RockPaper("rock");
//
//        rockPaperService=new RockPaperService(appUserRepository);
//        rockPaperController=new RockPaperController(rockPaperService);
//        when(appUserRepository).thenReturn();
//        when(rockPaperService.playRock(rockPaper)).thenReturn("rock");
//        String real= rockPaperService.playRock(rockPaper);
//        assertEquals("rock",real);
    }
}