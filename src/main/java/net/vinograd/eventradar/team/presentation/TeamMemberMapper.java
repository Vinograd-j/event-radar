package net.vinograd.eventradar.team.presentation;

import lombok.AllArgsConstructor;
import net.vinograd.eventradar.client.domain.Login;
import net.vinograd.eventradar.client.domain.UserId;
import net.vinograd.eventradar.team.domain.TeamId;
import net.vinograd.eventradar.team.domain.TeamMember;
import net.vinograd.eventradar.team.infrastructure.entity.JpaTeamMember;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TeamMemberMapper {

    public TeamMember convert(JpaTeamMember teamMember) {
        return new TeamMember(
                new TeamId(teamMember.getTeam().getId()),
                new UserId(teamMember.getUser().getId(), new Login(teamMember.getUser().getLogin())),
                teamMember.getTeamRole()
        );
    }

}
