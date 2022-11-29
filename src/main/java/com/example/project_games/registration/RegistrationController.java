package com.example.project_games.registration;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @PostMapping(path = "signup")
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }
    @PostMapping(path = "login")
    public String login(@RequestBody LoginResponse response) {
        return registrationService.login(response);
    }
    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }


}
