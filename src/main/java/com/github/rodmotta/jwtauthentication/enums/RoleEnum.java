package com.github.rodmotta.jwtauthentication.enums;

public enum RoleEnum {
    USER(1L),
    ADMIN(2L);

    public Long getId;

    RoleEnum(long id) {
        this.getId = id;
    }
}
