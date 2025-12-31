package net.vinograd.eventradar.team.presentation;

import lombok.AllArgsConstructor;
import net.vinograd.eventradar.client.presentation.UserMapper;
import net.vinograd.eventradar.team.domain.Team;
import net.vinograd.eventradar.team.domain.TeamDescription;
import net.vinograd.eventradar.team.domain.TeamId;
import net.vinograd.eventradar.team.domain.TeamMember;
import net.vinograd.eventradar.team.infrastructure.entity.JpaTeamMember;
import net.vinograd.eventradar.team.infrastructure.entity.TeamMemberId;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeamMemberMapper {

    private UserMapper userMapper;

    public TeamMember convert(JpaTeamMember teamMember) {
        return new TeamMember(
                new Team(new TeamId(teamMember.getTeam().getId()), new TeamDescription(teamMember.getTeam().getName(), teamMember.getTeam().getBio()), teamMember.getTeam().isActive()),
                userMapper.convert(teamMember.getUser()),
                teamMember.getTeamRole()
        );
        
    }

    public JpaTeamMember convert(TeamMember teamMember) {
        return new JpaTeamMember(
                new TeamMemberId(teamMember.getTeam().getId().getId(), teamMember.getUser().getId().getId()),
                new TeamMapper().convert(teamMember.getTeam()),
                userMapper.convert(teamMember.getUser()),
                teamMember.getRole()
        );
    }

}
