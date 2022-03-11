package com.github.rodmotta.jwtauthentication.dto.form;

import lombok.Data;

@Data
public class SignUpForm {

    private String username;
    private String password;
    private boolean admin;
}
