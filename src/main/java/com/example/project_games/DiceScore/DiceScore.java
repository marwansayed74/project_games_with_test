package com.example.project_games.DiceScore;

import lombok.ToString;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@ToString
public class DiceScore {

     private List<Integer> list=new ArrayList<>();

    public DiceScore() {
    }

    public DiceScore(List<Integer> list) {
        this.list = list;
    }
    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }
}
