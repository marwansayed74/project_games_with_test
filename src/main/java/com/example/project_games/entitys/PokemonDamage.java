package com.example.project_games.entitys;

import lombok.*;

@ToString
@Data
@AllArgsConstructor
public class PokemonDamage {
    private final String type;
    private final String opponentType;
    private final Integer attack;
    private final Integer defense;
}
