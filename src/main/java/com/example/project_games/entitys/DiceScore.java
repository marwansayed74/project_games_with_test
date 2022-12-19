package com.example.project_games.entitys;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class DiceScore {
     private List<Integer> list=new ArrayList<>();

    public DiceScore() {
    }

    public DiceScore(List<Integer> list) {
        this.list = list;
    }
}
