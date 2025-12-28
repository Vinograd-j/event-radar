package net.vinograd.eventradar.client.application;

import lombok.NonNull;
import net.vinograd.eventradar.client.domain.User;
import net.vinograd.eventradar.client.domain.UserId;

import java.util.Optional;

public interface UserRepository {

    boolean existById(@NonNull UserId userId);

    Optional<UserId> findById(@NonNull UserId userId);

    void save(@NonNull User user);

}