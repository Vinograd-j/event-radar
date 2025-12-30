package net.vinograd.eventradar.client.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.vinograd.eventradar.profile.domain.Profile;

@Getter
@AllArgsConstructor
public class User {

    private final UserId id;

    private final Username username;

    private final Profile profile;

    private boolean isActive;

    public void activate() {
        this.isActive = true;
    }

    public void deactivate() {
        this.isActive = false;
    }

}