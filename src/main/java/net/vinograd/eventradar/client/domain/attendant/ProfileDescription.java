package net.vinograd.eventradar.client.domain.attendant;

import lombok.Getter;

public class ProfileDescription {

    @Getter
    private final String bio;

    @Getter
    private final String displayName;

    public ProfileDescription(String bio, String displayName) {
        this.bio = bio;
        this.displayName = displayName;
    }

    private boolean isValid() {
        return bio.length() < 256 && displayName.matches("[A-Za-z]+") && displayName.length() <= 10;
    }

}