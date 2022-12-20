package com.example.project_games.entitys;
import lombok.*;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class RegistrationRequestDTO {
    private  String firstName;
    private  String lastName;
    private  String email;
    private  String password;

}
