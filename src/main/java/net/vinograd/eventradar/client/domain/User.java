package net.vinograd.eventradar.client.domain;

import lombok.Getter;

@Getter
public class User {

    private final UserId id;

    private final Username username;

    private final Profile profile;

    private boolean isActive;

    public User(UserId id, Username username, Profile profile) {
        this.id = id;
        this.username = username;
        this.profile = profile;
        this.isActive = true;
    }

    public void activate() {
        this.isActive = true;
    }

    public void deactivate() {
        this.isActive = false;
    }

}
