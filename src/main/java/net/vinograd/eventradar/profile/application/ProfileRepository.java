package net.vinograd.eventradar.profile.application;

import lombok.NonNull;
import net.vinograd.eventradar.profile.infrastructure.JpaProfile;

import java.util.Optional;
import java.util.UUID;

public interface ProfileRepository {

    Optional<JpaProfile> findById(@NonNull UUID profileId);

    void save(@NonNull JpaProfile profile);

    boolean existById(@NonNull UUID profileId);
}
