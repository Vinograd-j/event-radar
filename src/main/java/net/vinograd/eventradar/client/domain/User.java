package net.vinograd.eventradar.client.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class User {

    private final UUID id;

    private Login login;

    private final Username username;

    private final UUID profile;

    private boolean isActive;

    public void activate() {
        this.isActive = true;
    }

    public void deactivate() {
        this.isActive = false;
    }

}