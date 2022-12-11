package com.example.project_games.services;

import com.example.project_games.entitys.AppUser;
import com.example.project_games.appuser.AppUserRepository;
import com.example.project_games.entitys.TowerOfHanoi;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TowerOfHanoiService {
    private final AppUserRepository appUserRepository;
    public String playTowerOfHanoi(TowerOfHanoi tower) {
        String statment = "error";
        String output = "";
        AppUser appUser = appUserRepository.findByLocked(true).orElseThrow(() ->
                new IllegalStateException("there is no email loged in"));

        if(appUser.getLocked().equals(true)){
            statment =String.valueOf(Math.pow(2,tower.getDisk())-1);
            appUser.setScore(statment);
            appUser.setLocked(false);
            appUserRepository.save(appUser);
            return output + "" + statment;
        }
        return statment;
    }
}
