package net.vinograd.eventradar.client.infrastructure;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import net.vinograd.eventradar.client.application.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@AllArgsConstructor()
public class UserRepositoryImpl implements UserRepository {

    private JpaUserRepository jpaUserRepository;

    @Override
    public boolean existById(@NonNull UUID userId) {
        return this.jpaUserRepository.existsById(userId);
    }

    @Override
    public Optional<JpaUser> findById(@NonNull UUID userId) {
        return this.jpaUserRepository.findById(userId);
    }

    @Override
    public void save(@NonNull JpaUser user) {
        this.jpaUserRepository.save(user);
    }
}
