package com.example.project_games.controllers;

import com.example.project_games.entitys.DiceScore;
import com.example.project_games.services.DiceScoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/registration")
public class DiceScoreController {
    private final DiceScoreService diceScoreService;

    public DiceScoreController(DiceScoreService diceScoreService) {
        this.diceScoreService = diceScoreService;
    }
    @PostMapping(path = "dice")
    public ResponseEntity<String> playDiceScore(@RequestBody DiceScore dice) {
        diceScoreService.diceScore(dice);
        return new ResponseEntity<>("play done", HttpStatus.OK);
    }
}
