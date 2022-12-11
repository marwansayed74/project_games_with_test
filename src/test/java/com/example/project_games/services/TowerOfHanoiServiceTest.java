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

        AppUser appUser=new AppUser();
        appUser.setFirstName("marwan");
        appUser.setLastName("sayed");
        appUser.setLocked(true);
        appUser.setEmail("marwan@gmail.com");
        appUser.setEnabled(true);
        appUser.setAppUserRole(AppUserRole.USER);
        appUser.setPassword("password");

        TowerOfHanoi tower=new TowerOfHanoi();
        tower.setDisk(5);

        when(appUserRepository.findByLocked(true)).thenReturn(Optional.of(appUser));
        String real =towerOfHanoiService.playTowerOfHanoi(tower);

        assertEquals("31.0",real);
    }
}