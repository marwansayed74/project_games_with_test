package com.example.project_games.rockPaper;

import com.example.project_games.appuser.AppUser;
import com.example.project_games.appuser.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class RockPaperService {
    private final AppUserRepository appUserRepository;
    public String playRock(RockPaper rockPaper) {
        String statment = "error";

        AppUser appUser = appUserRepository.findByLocked(true).orElseThrow(() ->
                new IllegalStateException("there is no email loged in"));

        if(appUser.getLocked().equals(true)) {
            Random random = new Random();
            int randomNumber = random.nextInt(3);
            String computerMove;
            if (randomNumber == 0) {
                computerMove = "rock";
            } else if (randomNumber == 1) {
                computerMove = "paper";
            } else {
                computerMove = "scissor";
            }
            String output = "";
            output = "Computer chose " + computerMove + "!";


            if (rockPaper.getMove().equals("rock")) {
                if (computerMove.equals("rock")) {
                    statment = " the game is end draw";
                } else if (computerMove.equals("paper")) {
                    statment = " the computer win";
                } else if (computerMove.equals("scissor")) {
                    statment = " you win";
                }
            } else if (rockPaper.getMove().equals("paper")) {
                if (computerMove.equals("rock")) {
                    statment = " you win";
                } else if (computerMove.equals("paper")) {
                    statment = " the game is end draw";
                } else {
                    statment = " the computer win";
                }
            } else if (rockPaper.getMove().equals("scissor")) {
                if (computerMove.equals("rock")) {
                    statment = " the computer win";
                } else if (computerMove.equals("paper")) {
                    statment = " you win";
                } else if (computerMove.equals("scissor")) {
                    statment = " the game is end draw";
                }
            }
            appUser.setScore(statment);
            appUser.setLocked(false);
            appUserRepository.save(appUser);
            return output + "" + statment;
        }

        return statment;
    }
}