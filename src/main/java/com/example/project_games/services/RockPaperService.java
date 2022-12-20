package com.example.project_games.services;

import com.example.project_games.entitys.AppUser;
import com.example.project_games.appuser.AppUserRepository;
import com.example.project_games.entitys.RockPaper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
@Data
@NoArgsConstructor
public class RockPaperService {

    @Autowired
    private AppUserRepository appUserRepository;
    public String playRock(RockPaper rockPaper) {
        String statement = "error";
        String computerMove;
        AppUser appUser = appUserRepository.findByLocked(true).orElseThrow(() ->
                new IllegalStateException("there is no email loged in"));

        if(appUser.getLocked().equals(true)) {
            Random random = new Random();
            int randomNumber = random.nextInt(3);

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
                    statement = " the game is end draw";
                } else if (computerMove.equals("paper")) {
                    statement = " the computer win";
                } else if (computerMove.equals("scissor")) {
                    statement = " you win";
                }
            } else if (rockPaper.getMove().equals("paper")) {
                if (computerMove.equals("rock")) {
                    statement = " you win";
                } else if (computerMove.equals("paper")) {
                    statement = " the game is end draw";
                } else {
                    statement = " the computer win";
                }
            } else if (rockPaper.getMove().equals("scissor")) {
                if (computerMove.equals("rock")) {
                    statement = " the computer win";
                } else if (computerMove.equals("paper")) {
                    statement = " you win";
                } else if (computerMove.equals("scissor")) {
                    statement = " the game is end draw";
                }
            }
            appUser.setScore(statement);
            appUser.setLocked(false);
            appUserRepository.save(appUser);
            return output + "" + statement;
        }

        return statement;
    }
}