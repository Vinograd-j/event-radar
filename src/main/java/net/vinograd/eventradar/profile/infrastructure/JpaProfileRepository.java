package net.vinograd.eventradar.profile.infrastructure;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaProfileRepository extends JpaRepository<@NonNull JpaProfile, @NonNull UUID> {

}
