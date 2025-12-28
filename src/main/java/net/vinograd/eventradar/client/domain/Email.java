package net.vinograd.eventradar.client.domain;

import lombok.Getter;

public class Email {

    @Getter
    private final String email;

    public Email(String email) {
        if (isValid(email))
            throw new IllegalArgumentException("Invalid email address");
        this.email = email;
    }

    private boolean isValid(String value) {
        return value != null && value.matches(".+@.+\\..+");
    }

}