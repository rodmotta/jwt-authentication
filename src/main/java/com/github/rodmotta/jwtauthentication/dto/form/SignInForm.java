package com.github.rodmotta.jwtauthentication.dto.form;

import lombok.Data;

@Data
public class SignInForm {

    private String username;
    private String password;
}
