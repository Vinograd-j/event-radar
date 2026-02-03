package net.vinograd.eventradar.team.infrastructure.repository;

import lombok.NonNull;
import net.vinograd.eventradar.team.infrastructure.entity.JpaTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaTeamRepository extends JpaRepository<@NonNull JpaTeam, @NonNull UUID> {

    boolean findByName(String name);

}