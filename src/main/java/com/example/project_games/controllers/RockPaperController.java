package com.example.project_games.controllers;

import com.example.project_games.entitys.RockPaper;
import com.example.project_games.services.RockPaperService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/registration")
public class RockPaperController {

    public RockPaperController(RockPaperService rockPaperService) {
        this.rockPaperService = rockPaperService;
    }

    private RockPaperService rockPaperService;

    @PostMapping(path = "/play")
    public ResponseEntity<String> playRock(@RequestBody RockPaper rock) {
       return new ResponseEntity<>(rockPaperService.playRock(rock), HttpStatus.OK);
    }
}
