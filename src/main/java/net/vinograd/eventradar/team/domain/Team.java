package net.vinograd.eventradar.team.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;


@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Team {

    private final UUID id;

    private final TeamDescription description;

    private boolean isActive;

    public static Team create(TeamDescription description) {
        return new Team(UUID.randomUUID(), description, true);
    }

    public static Team restore(UUID id, TeamDescription description, boolean active) {
        return new Team(id, description, active);
    }

    public void deactivate() {
        this.isActive = false;
    }

    public void activate() {
        this.isActive = true;
    }

}
