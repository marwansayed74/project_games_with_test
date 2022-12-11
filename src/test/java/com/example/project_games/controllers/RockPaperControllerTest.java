package com.example.project_games.controllers;

import com.example.project_games.entitys.AppUser;
import com.example.project_games.appuser.AppUserRepository;
import com.example.project_games.controllers.RockPaperController;
import com.example.project_games.entitys.RockPaper;
import com.example.project_games.services.RockPaperService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

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