package net.vinograd.eventradar.team.infrastructure.mapper;

import net.vinograd.eventradar.team.domain.Team;
import net.vinograd.eventradar.team.domain.TeamDescription;
import net.vinograd.eventradar.team.infrastructure.entity.JpaTeam;
import org.springframework.stereotype.Component;

@Component
public class TeamMapper {

    public Team convert(JpaTeam jpaTeam) {
        return Team.restore(
                jpaTeam.getId(),
                new TeamDescription(jpaTeam.getName(), jpaTeam.getBio()),
                jpaTeam.isActive()
        );
    }

    public JpaTeam convert(Team team) {
        return new JpaTeam(
                team.getId(),
                team.getDescription().getTeamName(),
                team.getDescription().getTeamBio(),
                team.isActive()
            );
    }

}