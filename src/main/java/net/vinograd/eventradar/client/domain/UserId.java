package net.vinograd.eventradar.client.domain;

import lombok.Getter;

import java.util.UUID;

@Getter
public class UserId {

    private final UUID id;

    private final Login login;

    public UserId(String login) {
        this.login = new Login(login);
        this.id = UUID.randomUUID();
    }

}