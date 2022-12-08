package com.example.project_games.rockPaper;

import com.example.project_games.appuser.AppUser;
import com.example.project_games.appuser.AppUserRepository;
import com.example.project_games.appuser.AppUserRole;
import com.example.project_games.registration.RegistrationController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
@WebAppConfiguration
@SpringBootTest(classes = RockPaperController.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = RockPaperController.class)

class RockPaperControllerURlTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RockPaperService rockPaperService;
    @MockBean
    private AppUserRepository appUserRepository;
    private static ObjectMapper mapper = new ObjectMapper();

    @Test
    void playRockController() throws Exception {
        AppUser appUser=new AppUser("marwan","sayed","marwan@gmail.com","password", AppUserRole.USER);
        appUser.setLocked(true);
        appUser.setEnabled(true);
        RockPaper rockPaper=new RockPaper();
        rockPaper.setMove("rock");
        Mockito.when(appUserRepository.findByLocked(true)).thenReturn(Optional.of(appUser));
        Mockito.when(rockPaperService.playRock(ArgumentMatchers.any())).thenReturn("you win");
        rockPaperService.playRock(rockPaper);
        String json = mapper.writeValueAsString(rockPaper);
        mockMvc.perform(post("http://127.0.0.1:9080/api/v1/registration/play")
                        .contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                        .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
                .andExpect(jsonPath("$.move", Matchers.equalTo("rock")));
    }
}