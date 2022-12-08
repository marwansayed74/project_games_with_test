package com.example.project_games.DiceScore;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

class DiceScoreControllerUrlTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DiceScoreService diceScoreService;

    private static ObjectMapper mapper = new ObjectMapper();

    @Test
    void playDiceScore() {




    }
}