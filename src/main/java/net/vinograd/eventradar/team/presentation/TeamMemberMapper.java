package net.vinograd.eventradar.team.presentation;

import lombok.AllArgsConstructor;
import net.vinograd.eventradar.team.domain.TeamMember;
import net.vinograd.eventradar.team.infrastructure.entity.JpaTeamMember;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TeamMemberMapper {

    public TeamMember convert(JpaTeamMember teamMember) {
        return new TeamMember(
                teamMember.getTeam().getId(),
                teamMember.getUser().getId(),
                teamMember.getTeamRole()
        );
    }

}
