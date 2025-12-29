package net.vinograd.eventradar.client.application;

import lombok.NonNull;
import net.vinograd.eventradar.client.infrastructure.JpaUser;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    boolean existById(@NonNull UUID userId);

    Optional<JpaUser> findById(@NonNull UUID userId);

    void save(@NonNull JpaUser user);

}