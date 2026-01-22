package net.vinograd.eventradar.client.domain.root;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.vinograd.eventradar.client.domain.attendant.Email;
import net.vinograd.eventradar.client.domain.attendant.Login;

import java.util.UUID;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

    private final UUID id;

    private Login login;

    private final Email email;

    private Profile profile;

    private boolean isActive;

    public static User create(Login login, Email email, Profile profile) {
        return new User(UUID.randomUUID(), login, email, profile, true);
    }

    public static User restore(UUID id, Login login, Email email, Profile profile, boolean active) {
        return new User(id, login, email, profile, active);
    }

    public void activate() {
        this.isActive = true;
    }

    public void deactivate() {
        this.isActive = false;
    }

}