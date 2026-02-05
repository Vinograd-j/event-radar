package net.vinograd.eventradar.client.domain.root;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.vinograd.eventradar.client.domain.attendant.Username;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Profile {

    private String displayName;

    private Username username;

    private String bio;

    public static Profile restore(String displayName, String firstName, String lastName, String bio) {
        return new Profile(displayName, new Username(firstName, lastName), bio);
    }

    public static Profile defaultProfile(String displayName, String firstName, String lastName) {
        return new Profile(displayName, new Username(firstName, lastName), "");
    }

    public void changeBio(String newBio) {
        this.bio = newBio;
    }

    public void changeDisplayName(String newDisplayName) {
        this.displayName = newDisplayName;
    }

}
