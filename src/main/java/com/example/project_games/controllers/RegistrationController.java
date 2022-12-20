package com.example.project_games.controllers;
import com.example.project_games.entitys.RegistrationRequestDTO;
import com.example.project_games.services.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/registration")
@AllArgsConstructor
public class RegistrationController {
    private  RegistrationService registrationService;

    @PostMapping(path = "/signup")
    public ResponseEntity<String> register(@RequestBody RegistrationRequestDTO request) {
        return new ResponseEntity<>(registrationService.register(request), HttpStatus.CREATED);
    }
    @PostMapping(path = "/login")
    public ResponseEntity<String> login(@RequestBody RegistrationRequestDTO request) {
        return  new ResponseEntity<>(registrationService.login(request), HttpStatus.OK);
    }
    @GetMapping(path = "/confirm")
    public ResponseEntity<String> confirm(@RequestParam("token") String token) {
        return new ResponseEntity<>(registrationService.confirmToken(token), HttpStatus.OK);
    }


}
