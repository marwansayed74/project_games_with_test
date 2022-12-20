package com.example.project_games.services;

import com.example.project_games.entitys.AppUser;
import com.example.project_games.appuser.AppUserRepository;
import com.example.project_games.appuser.AppUserRole;
import com.example.project_games.entitys.TowerOfHanoi;
import com.example.project_games.services.TowerOfHanoiService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TowerOfHanoiServiceTest {
    @InjectMocks
    private TowerOfHanoiService towerOfHanoiService;
    @Mock
    private AppUserRepository appUserRepository;
    @Test
    void playTowerOfHanoi() {

        AppUser appUser=new AppUser("marwan","sayed","marwan@gmail.com","password",AppUserRole.USER);
        appUser.setLocked(true);
        appUser.setEnabled(true);
        TowerOfHanoi tower=new TowerOfHanoi(5);
        when(appUserRepository.findByLocked(true)).thenReturn(Optional.of(appUser));
        assertEquals("31.0",towerOfHanoiService.playTowerOfHanoi(tower));
    }
}