package net.vinograd.eventradar.client.infrastructure.reposiroty;

import lombok.NonNull;
import net.vinograd.eventradar.client.infrastructure.entities.JpaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaUserRepository extends JpaRepository<@NonNull JpaUser, @NonNull UUID> {
}