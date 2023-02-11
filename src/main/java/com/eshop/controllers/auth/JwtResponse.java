package com.eshop.controllers.auth;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {

    private Long id;
    private String token;
    private String type;
    private String username;
    private List<String> roles;
}
