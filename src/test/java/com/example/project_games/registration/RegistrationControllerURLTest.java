package com.example.project_games.registration;

import com.example.project_games.appuser.AppUser;
import com.example.project_games.appuser.AppUserRole;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@AutoConfigureMockMvc
@SpringBootTest(classes = RegistrationController.class)
class RegistrationControllerURLTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RegistrationService registrationService;

    private static ObjectMapper mapper = new ObjectMapper();

    @Test
    void registerUrltest() throws Exception {

//        AppUser appUser = new AppUser("marwan", "sayed", "marwan@gmail.com", "password", AppUserRole.USER);
//        appUser.setLocked(true);
//        appUser.setEnabled(true);
//        RegistrationRequest registrationRequest = new RegistrationRequest("marwan", "sayed", "marwan@gmail.com", "password");
//        Mockito.when(registrationService.register(registrationRequest)).thenReturn("token");
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/registration/signup")
//                        .content(asJsonString(appUser))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE))
//                .andExpect(status().isCreated())
//                .andExpect(content().contentType("application/json;charset=UTF-8"));


//        AppUser appUser=new AppUser("marwan","sayed","marwan@gmail.com","password", AppUserRole.USER);
//        appUser.setLocked(true);
//        appUser.setEnabled(true);
//        Mockito.when(registrationService.register(ArgumentMatchers.any())).thenReturn("token");
//        String json = mapper.writeValueAsString("token");
//        mockMvc.perform(post("/api/v1/registration/signup").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
//                        .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
//                .andExpect(jsonPath("$.firstName", Matchers.equalTo("marwan")))
//                .andExpect(jsonPath("$.lastName", Matchers.equalTo("sayed")))
//                .andExpect(jsonPath("$.email", Matchers.equalTo("marwan@gmail.com")))
//                .andExpect(jsonPath("$.password", Matchers.equalTo("password")));

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}