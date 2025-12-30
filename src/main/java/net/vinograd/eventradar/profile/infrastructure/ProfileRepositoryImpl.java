package net.vinograd.eventradar.profile.infrastructure;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import net.vinograd.eventradar.profile.application.ProfileRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class ProfileRepositoryImpl implements ProfileRepository {

    private final JpaProfileRepository jpaProfileRepository;

    @Override
    public Optional<JpaProfile> findById(@NonNull UUID profileId) {
        return this.jpaProfileRepository.findById(profileId);
    }

    @Override
    public void save(@NonNull JpaProfile profile) {
        this.jpaProfileRepository.save(profile);
    }

    @Override
    public boolean existById(@NonNull UUID profileId) {
        return this.jpaProfileRepository.existsById(profileId);
    }

}
