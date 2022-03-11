package com.github.rodmotta.jwtauthentication.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenDto {

    private String type;
    private String token;
}
