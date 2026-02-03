package net.vinograd.eventradar.client.application.port;

import lombok.NonNull;
import net.vinograd.eventradar.client.domain.root.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    boolean existById(@NonNull UUID userId);

    Optional<User> findById(@NonNull UUID userId);

    boolean existByLogin(@NonNull String login);

    void save(@NonNull User user);

}