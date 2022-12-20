package com.example.project_games.services;

import com.example.project_games.entitys.AppUser;
import com.example.project_games.appuser.AppUserRepository;
import com.example.project_games.entitys.PokemonDamage;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PokemonDamageService {
    @Autowired
    private  AppUserRepository appUserRepository;
    public String pokemonDamage(PokemonDamage pokemon) {
        String statment="error" ;
        int damage;
        AppUser appUser = appUserRepository.findByLocked(true).orElseThrow(() ->
                new IllegalStateException("there is no email loged in"));
        if(appUser.getLocked().equals(true)){
                 damage = 50 * (pokemon.getAttack()/pokemon.getDefense());
                if        ((pokemon.getType().equals("fire")  && pokemon.getOpponentType().equals("grass"))
                        || (pokemon.getType().equals("water") && pokemon.getOpponentType().equals("fire"))
                        || (pokemon.getType().equals("grass") &&  pokemon.getOpponentType().equals("water")))
                {
                    statment=String.valueOf(damage * 2);
                    appUser.setScore(statment);
                    appUser.setLocked(false);
                    appUserRepository.save(appUser);
                    return statment;
                }
                else if((pokemon.getType().equals("grass") &&  pokemon.getOpponentType().equals("fire") )
                        || (pokemon.getType().equals("fire")  && pokemon.getOpponentType().equals("water") )
                        || (pokemon.getType().equals("water")  &&  pokemon.getOpponentType().equals("grass")))
                {
                    statment=String.valueOf(damage * 0.5);
                    appUser.setScore(statment);
                    appUser.setLocked(false);
                    appUserRepository.save(appUser);
                    return statment;
                }
                else
                {
                    statment=String.valueOf(damage);
                    appUser.setScore(statment);
                    appUser.setLocked(false);
                    appUserRepository.save(appUser);
                    return statment;
                }
        }
        return statment;
    }
}
