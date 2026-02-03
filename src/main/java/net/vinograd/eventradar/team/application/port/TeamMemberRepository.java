package net.vinograd.eventradar.team.application.port;

import lombok.NonNull;
import net.vinograd.eventradar.client.domain.root.User;
import net.vinograd.eventradar.team.domain.Team;
import net.vinograd.eventradar.team.infrastructure.entity.TeamMemberId;

import java.util.Set;
import java.util.UUID;

public interface TeamMemberRepository {

    Set<Team> findAllUserTeams(@NonNull UUID memberId);

    Set<User> findAllTeamMembers(@NonNull UUID teamId);

    void deleteTeamMember(TeamMemberId teamMemberId);

    void addTeamMember(TeamMemberId teamMemberId);

}
