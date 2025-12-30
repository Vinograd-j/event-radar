package net.vinograd.eventradar.team.application;

import lombok.NonNull;
import net.vinograd.eventradar.client.infrastructure.JpaUser;
import net.vinograd.eventradar.team.infrastructure.entity.JpaTeam;
import net.vinograd.eventradar.team.infrastructure.entity.JpaTeamMember;

import java.util.Set;
import java.util.UUID;

public interface TeamMemberRepository {

    void save(@NonNull JpaTeamMember teamMember);

    Set<JpaTeam> findAllUserTeams(@NonNull UUID memberId);

    Set<JpaUser> findAllTeamMembers(@NonNull UUID teamId);

    void deleteTeamMember(JpaTeamMember teamMember);


}