package net.vinograd.eventradar.team.domain;

import lombok.Getter;

import java.util.UUID;

@Getter
public class TeamId {

    private final UUID id;

    public TeamId(UUID id) {
        this.id = UUID.randomUUID();
    }

}