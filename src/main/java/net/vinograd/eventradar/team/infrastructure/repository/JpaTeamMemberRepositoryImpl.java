package net.vinograd.eventradar.team.infrastructure.repository;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import net.vinograd.eventradar.client.infrastructure.JpaUser;
import net.vinograd.eventradar.team.application.TeamMemberRepository;
import net.vinograd.eventradar.team.infrastructure.entity.JpaTeam;
import net.vinograd.eventradar.team.infrastructure.entity.JpaTeamMember;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class JpaTeamMemberRepositoryImpl implements TeamMemberRepository {

    private final JpaTeamMemberRepository jpaTeamMemberRepository;

    @Override
    public void save(@NonNull JpaTeamMember teamMember) {
        this.jpaTeamMemberRepository.save(teamMember);
    }

    @Override
    public Set<JpaTeam> findAllUserTeams(@NonNull UUID memberId) {
        return this.jpaTeamMemberRepository.findAllByUserId(memberId).
                stream().map(JpaTeamMember::getTeam).
                collect(Collectors.toSet());
    }

    @Override
    public Set<JpaUser> findAllTeamMembers(@NonNull UUID teamId) {
        return this.jpaTeamMemberRepository.findAllByTeamId(teamId).
                stream().map(JpaTeamMember::getUser).
                collect(Collectors.toSet());
    }

    @Override
    public void deleteTeamMember(JpaTeamMember teamMember) {
        this.jpaTeamMemberRepository.delete(teamMember);
    }

}
