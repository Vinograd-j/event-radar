package net.vinograd.eventradar.client.domain.root;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.vinograd.eventradar.client.domain.attendant.ProfileDescription;
import net.vinograd.eventradar.client.domain.attendant.Username;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Profile {

    private Username username;

    private ProfileDescription description;

    public static Profile restore(String firstName, String lastName, String displayName, String bio) {
        return new Profile(new Username(firstName, lastName), new  ProfileDescription(displayName, bio));
    }

    public static Profile defaultProfile(String displayName, String firstName, String lastName) {
        return new Profile(new Username(firstName, lastName), new   ProfileDescription(displayName, ""));
    }

    public void changeProfileDescription(ProfileDescription description) {
        this.description = description;
    }

}