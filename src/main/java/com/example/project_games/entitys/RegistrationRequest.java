package com.example.project_games.entitys;
import lombok.*;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class RegistrationRequest {
    private  String firstName;
    private  String lastName;
    private  String email;
    private  String password;

//    public RegistrationRequest(String s, String password) {
//    }
}
