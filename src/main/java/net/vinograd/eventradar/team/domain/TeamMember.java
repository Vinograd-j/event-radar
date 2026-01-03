package net.vinograd.eventradar.team.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.vinograd.eventradar.client.domain.UserId;

@AllArgsConstructor
@Getter
public class TeamMember {

    private TeamId team;

    private UserId user;

    private TeamRole role;

}
