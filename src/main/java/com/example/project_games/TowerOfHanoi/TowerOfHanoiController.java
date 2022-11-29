package com.example.project_games.TowerOfHanoi;

import com.example.project_games.rockPaper.RockPaper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/registration")
public class TowerOfHanoiController {
    private final TowerOfHanoiService towerOfHanoiService ;

    public TowerOfHanoiController(TowerOfHanoiService towerOfHanoiService) {
        this.towerOfHanoiService = towerOfHanoiService;
    }
    @PostMapping(path = "tower")
    public String playTowerOfHanoi(@RequestBody TowerOfHanoi tower) {
        return towerOfHanoiService.playTowerOfHanoi(tower);
    }
}
