package net.vinograd.eventradar.team.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.vinograd.eventradar.client.domain.User;

@AllArgsConstructor
@Getter
public class TeamMember {

    private Team team;

    private User user;

    private TeamRole role;

}
