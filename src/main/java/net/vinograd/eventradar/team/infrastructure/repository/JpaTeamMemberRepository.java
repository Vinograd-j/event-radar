package net.vinograd.eventradar.team.infrastructure.repository;

import lombok.NonNull;
import net.vinograd.eventradar.team.infrastructure.entity.JpaTeamMember;
import net.vinograd.eventradar.team.domain.TeamMemberId;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;
import java.util.UUID;

public interface JpaTeamMemberRepository extends CrudRepository<@NonNull JpaTeamMember, @NonNull TeamMemberId> {

    Set<JpaTeamMember> findAllByIdTeamId(UUID teamId);

    Set<JpaTeamMember> findAllByIdUserId(UUID userId);

}
