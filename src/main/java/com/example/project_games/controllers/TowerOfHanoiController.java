package com.example.project_games.controllers;

import com.example.project_games.entitys.TowerOfHanoi;
import com.example.project_games.services.TowerOfHanoiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> playTowerOfHanoi(@RequestBody TowerOfHanoi tower) {
        return new ResponseEntity<>(towerOfHanoiService.playTowerOfHanoi(tower), HttpStatus.OK);
    }
}
