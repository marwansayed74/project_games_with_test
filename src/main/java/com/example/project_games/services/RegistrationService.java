package com.example.project_games.services;
import com.example.project_games.entitys.AppUser;
import com.example.project_games.appuser.AppUserRepository;
import com.example.project_games.appuser.AppUserRole;
import com.example.project_games.registration.EmailValidator;
import com.example.project_games.entitys.LoginResponse;
import com.example.project_games.entitys.RegistrationRequest;
import com.example.project_games.registration.token.ConfirmationToken;
import com.example.project_games.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {
    @Autowired
    private  AppUserService appUserService;
    @Autowired
    private  AppUserRepository appUserRepository;
    @Autowired
    private EmailValidator emailValidator;
    @Autowired
    private ConfirmationTokenService confirmationTokenService;
    @Autowired
    private  BCryptPasswordEncoder bCryptPasswordEncoder;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.
                test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }
        String token = appUserService.signUpUser(
                new AppUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );
        return token;
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        appUserService.enableAppUser(
                confirmationToken.getAppUser().getEmail());
        return "confirmed";
    }
    public String login(LoginResponse response) {
        AppUser appUser = appUserRepository.findByEmail(response.getEmail()).orElseThrow(() ->
                new IllegalStateException("user with email" + response.getEmail() + "error"));
        if(appUser.getEmail().equals(response.getEmail()) &&
                bCryptPasswordEncoder.matches(response.getPassword(),appUser.getPassword())
        && appUser.getEnabled())
        {
            appUser.setLocked(true);
            appUserRepository.save(appUser);
            return "you are in";
        }
        return "error";
    }
}
