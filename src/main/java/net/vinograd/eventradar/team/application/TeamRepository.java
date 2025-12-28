package net.vinograd.eventradar.team.application;

import lombok.NonNull;
import net.vinograd.eventradar.client.domain.User;
import net.vinograd.eventradar.client.domain.UserId;
import net.vinograd.eventradar.team.domain.Team;
import net.vinograd.eventradar.team.domain.TeamId;

import java.util.Optional;

public interface TeamRepository {

    boolean existById(@NonNull TeamId teamId);

    Optional<UserId> findById(@NonNull TeamId teamId);

    void save(@NonNull Team team);

}
