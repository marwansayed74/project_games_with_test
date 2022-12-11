package com.example.project_games.controllers;
import com.example.project_games.entitys.LoginResponse;
import com.example.project_games.entitys.RegistrationRequest;
import com.example.project_games.services.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/registration")
@AllArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @PostMapping(path = "/signup")
    public ResponseEntity<String> register(@RequestBody RegistrationRequest request) {
        registrationService.register(request);
        return new ResponseEntity<>("play done", HttpStatus.CREATED);
    }
    @PostMapping(path = "/login")
    public ResponseEntity<String> login(@RequestBody LoginResponse response) {
        registrationService.login(response);
        return  new ResponseEntity<>("user sign in done ", HttpStatus.OK);
    }
    @GetMapping(path = "/confirm")
    public ResponseEntity<String> confirm(@RequestParam("token") String token) {
        registrationService.confirmToken(token);
        return new ResponseEntity<>("user sign in done ", HttpStatus.OK);

    }


}
