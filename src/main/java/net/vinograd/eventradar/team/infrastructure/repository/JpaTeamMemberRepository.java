package net.vinograd.eventradar.team.infrastructure.repository;

import lombok.NonNull;
import net.vinograd.eventradar.team.infrastructure.entity.JpaTeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface JpaTeamMemberRepository extends JpaRepository<@NonNull JpaTeamMember, @NonNull UUID> {

    Set<JpaTeamMember> findAllByUserId(UUID userId);

    Set<JpaTeamMember> findAllByTeamId(UUID teamId);

}