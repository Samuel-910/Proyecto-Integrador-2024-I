package com.example.msauth.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserDto {
    private Integer id;
    private String userName;
    private String password;
}
