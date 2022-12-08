package com.example.project_games.rockPaper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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
    public String playRock(@RequestBody RockPaper rock) {
        return rockPaperService.playRock(rock);
    }
}
