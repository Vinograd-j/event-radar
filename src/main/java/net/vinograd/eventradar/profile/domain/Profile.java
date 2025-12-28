package net.vinograd.eventradar.profile.domain;

import lombok.Getter;
import net.vinograd.eventradar.client.domain.Email;
import net.vinograd.eventradar.client.domain.User;

@Getter
public class Profile {

    private final User user;

    private String displayName;

    private Email email;

    private String bio;

    public Profile(User user, String displayName, Email email, String bio) {
        this.user = user;
        this.displayName = displayName;
        this.email = email;
        this.bio = bio;
    }

    public void changeBio(String newBio) {
        this.bio = newBio;
    }

    public void changeEmail(Email newEmail) {
        this.email = newEmail;
    }

    public void changeDisplayName(String newDisplayName) {
        this.displayName = newDisplayName;
    }

}
