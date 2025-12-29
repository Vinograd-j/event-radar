package net.vinograd.eventradar.team.infrastructure;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaTeamRepository extends JpaRepository<@NonNull JpaTeam, @NonNull UUID> {

}
