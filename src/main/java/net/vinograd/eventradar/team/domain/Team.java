package net.vinograd.eventradar.team.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;


@Getter
@AllArgsConstructor
public class Team {

    private final UUID id;

    private final TeamDescription description;

    private boolean isActive;

    public void deactivate() {
        this.isActive = false;
    }

    public void activate() {
        this.isActive = true;
    }

}
