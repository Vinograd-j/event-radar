package net.vinograd.eventradar.profile.domain;

import lombok.Getter;

import java.util.UUID;

public class ProfileId {

    @Getter
    private final UUID id;

    public ProfileId(UUID id) {
        this.id = id;
    }

}
