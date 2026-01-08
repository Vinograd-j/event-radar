package net.vinograd.eventradar.team.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class TeamMember {

    private UUID team;

    private UUID user;

    private TeamRole role;

}
