package net.vinograd.eventradar.profile.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.vinograd.eventradar.client.domain.Email;

@Getter
@AllArgsConstructor
public class Profile {

    private ProfileId id;

    private String displayName;

    private Email email;

    private String bio;

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
