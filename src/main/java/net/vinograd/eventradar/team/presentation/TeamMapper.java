package net.vinograd.eventradar.team.presentation;

import net.vinograd.eventradar.client.domain.Login;
import net.vinograd.eventradar.client.domain.UserId;
import net.vinograd.eventradar.client.infrastructure.JpaUser;
import net.vinograd.eventradar.team.domain.Team;
import net.vinograd.eventradar.team.domain.TeamDescription;
import net.vinograd.eventradar.team.domain.TeamId;
import net.vinograd.eventradar.team.domain.TeamMember;
import net.vinograd.eventradar.team.infrastructure.entity.JpaTeam;

import java.util.stream.Collectors;

public class TeamMapper {

    public Team convert(JpaTeam jpaTeam) {
        return new Team(
                new TeamId(jpaTeam.getId()),
                new TeamDescription(jpaTeam.getName(), jpaTeam.getDescription()),
                jpaTeam.getMembers().
                        stream()
                        .map(member -> {
                            JpaUser jpaUser = member.getUser();
                            return new TeamMember(
                                    new UserId(jpaUser.getId(),
                                    new Login(jpaUser.getLogin())),
                                    new TeamId(member.getTeam().getId()),
                                    member.getTeamRole());
                        }).collect(Collectors.toSet()),

                jpaTeam.isActive()
        );
    }

}