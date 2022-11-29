package com.example.project_games.rockPaper;


import lombok.ToString;

@ToString
public class RockPaper {
    private String move;

    public RockPaper() {
    }

    public RockPaper(String move) {
        this.move = move;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }
}
