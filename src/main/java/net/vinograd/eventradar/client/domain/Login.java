package net.vinograd.eventradar.client.domain;

import lombok.Getter;

public class Login {

    @Getter
    private final String login;

    public Login(String login) {
        if (!isValid(login))
            throw new IllegalArgumentException("Invalid login");
        this.login = login;
    }

    private boolean isValid(String login) {
        return login != null && !login.isBlank() && login.matches("^[a-z]+$");
    }

}
