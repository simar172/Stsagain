package com.example.ytproj.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    int id;
    @NotEmpty
    String name;
    @Email
    String email;
    @NotEmpty
    String password;
    @NotEmpty
    String about;
}