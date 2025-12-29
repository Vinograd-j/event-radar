package net.vinograd.eventradar.client.infrastructure;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaUserRepository extends JpaRepository<@NonNull JpaUser, @NonNull UUID> {

}