package net.vinograd.eventradar.team.application;

import lombok.NonNull;
import net.vinograd.eventradar.team.infrastructure.JpaTeam;

import java.util.Optional;
import java.util.UUID;

public interface TeamRepository {

    boolean existById(@NonNull UUID teamId);

    Optional<JpaTeam> findById(@NonNull UUID teamId);

    void save(@NonNull JpaTeam team);

}