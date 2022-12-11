package com.example.project_games.services;

import com.example.project_games.entitys.AppUser;
import com.example.project_games.appuser.AppUserRepository;
import com.example.project_games.entitys.DiceScore;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DiceScoreService {
    private final AppUserRepository appUserRepository;
    public String diceScore(DiceScore dice) {
        String statment = "error";

        AppUser appUser = appUserRepository.findByLocked(true).orElseThrow(() ->
                new IllegalStateException("there is no email loged in"));
        if(appUser.getLocked().equals(true)){
            int oneCount = 0;
            int twoCount = 0;
            int threeCount = 0;
            int fourCount = 0;
            int fiveCount = 0;
            int sixCount = 0;
            int totalScore = 0;
            // Record number of times each number was rolled
            for (int i = 0; i < dice.getList().size(); i++) {
                if (dice.getList().get(i) == 1) {
                    oneCount++;
                } else if (dice.getList().get(i) == 2) {
                    twoCount++;
                } else if (dice.getList().get(i) == 3) {
                    threeCount++;
                } else if (dice.getList().get(i) == 4) {
                    fourCount++;
                } else if (dice.getList().get(i)== 5) {
                    fiveCount++;
                } else if (dice.getList().get(i)== 6) {
                    sixCount++;
                }
            }
            // Check for amount of times each number was rolled
            if (oneCount == 3) {
                totalScore += 1000;
            } else if (twoCount == 3) {
                totalScore += 200;
            } else if (threeCount == 3) {
                totalScore += 300;
            } else if (fourCount == 3) {
                totalScore += 400;
            } else if (fiveCount == 3) {
                totalScore += 500;
            } else if (sixCount == 3) {
                totalScore += 600;
            }

            // Check for instance of one '1'
            if (oneCount == 1) {
                totalScore += 100;
            }

            // Check for instance of one '5'
            if (fiveCount == 1) {
                totalScore += 50;
            }
            statment= String.valueOf(totalScore);
            appUser.setScore(statment);
            appUser.setLocked(false);
            appUserRepository.save(appUser);
            return  "" + statment;
        }
        return statment;
    }
}
