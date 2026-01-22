package net.vinograd.eventradar.team.application;

import lombok.NonNull;
import net.vinograd.eventradar.team.domain.Team;

import java.util.Optional;
import java.util.UUID;

public interface TeamRepository {

    boolean existById(@NonNull UUID teamId);

    Optional<Team> findById(@NonNull UUID teamId);

    void save(@NonNull Team team);

}