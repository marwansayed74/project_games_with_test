package com.example.project_games.entitys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class PokemonDamage {
    private final String type;
    private final String opponentType;
    private final Integer attack;
    private final Integer defense;

}
