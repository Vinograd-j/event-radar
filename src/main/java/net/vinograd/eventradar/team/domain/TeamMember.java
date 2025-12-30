package net.vinograd.eventradar.team.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.vinograd.eventradar.client.domain.UserId;


@AllArgsConstructor
@Getter
public class TeamMember {

    private UserId userId;

    private TeamId teamId;

    private TeamRole role;

}
