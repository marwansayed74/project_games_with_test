package com.example.project_games.DiceScore;

import com.example.project_games.rockPaper.RockPaper;
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
    public String playDiceScore(@RequestBody DiceScore dice) {
        return diceScoreService.diceScore(dice);
    }
}
