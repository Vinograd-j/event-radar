package net.vinograd.eventradar.profile.application;

import lombok.NonNull;
import net.vinograd.eventradar.profile.domain.Profile;
import net.vinograd.eventradar.profile.domain.ProfileId;

import java.util.Optional;

public interface ProfileRepository {

    Optional<Profile> findById(@NonNull ProfileId profileId);

    void save(@NonNull Profile profile);

    boolean existById(@NonNull ProfileId profileId);

}
