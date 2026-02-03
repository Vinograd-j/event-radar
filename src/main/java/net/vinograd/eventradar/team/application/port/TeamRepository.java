package net.vinograd.eventradar.team.application.port;

import lombok.NonNull;
import net.vinograd.eventradar.team.domain.Team;

import java.util.Optional;
import java.util.UUID;

public interface TeamRepository {

    boolean existById(@NonNull UUID teamId);

    Optional<Team> findById(@NonNull UUID teamId);

    boolean existByName(@NonNull String name);

    void save(@NonNull Team team);

}