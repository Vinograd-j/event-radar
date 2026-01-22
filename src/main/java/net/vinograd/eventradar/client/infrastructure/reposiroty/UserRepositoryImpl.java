package net.vinograd.eventradar.client.infrastructure.reposiroty;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import net.vinograd.eventradar.client.application.UserRepository;
import net.vinograd.eventradar.client.domain.root.User;
import net.vinograd.eventradar.client.infrastructure.mapper.UserMapper;
import net.vinograd.eventradar.team.infrastructure.repository.TeamRepositoryImpl;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private JpaUserRepository jpaUserRepository;

    private UserMapper userMapper;

    private TeamRepositoryImpl teamRepository;

    @Override
    public boolean existById(@NonNull UUID userId) {
        return this.jpaUserRepository.existsById(userId);
    }

    @Override
    public Optional<User> findById(@NonNull UUID userId) {
        return this.jpaUserRepository.findById(userId).map(userMapper::convert);
    }

    @Override
    public void save(@NonNull User user) {
        jpaUserRepository.save(userMapper.convert(user));
    }

}
