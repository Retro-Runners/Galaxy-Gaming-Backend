package com.revature.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String password;
}
