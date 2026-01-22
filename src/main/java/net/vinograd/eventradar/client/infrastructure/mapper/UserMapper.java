package net.vinograd.eventradar.client.infrastructure.mapper;

import lombok.AllArgsConstructor;
import net.vinograd.eventradar.client.domain.attendant.Email;
import net.vinograd.eventradar.client.domain.attendant.Login;
import net.vinograd.eventradar.client.domain.root.User;
import net.vinograd.eventradar.client.infrastructure.entities.JpaUser;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserMapper {

    private final ProfileMapper profileMapper;

    public User convert(JpaUser jpaUser) {
        return User.restore(
                jpaUser.getId(),
                new Login(jpaUser.getLogin()),
                new Email(jpaUser.getEmail()),
                profileMapper.convert(jpaUser.getProfile()),
                jpaUser.isActive()
        );
    }

    public JpaUser convert(User user) {
        return new JpaUser(
                user.getId(),
                user.getLogin().value(),
                user.getEmail().value(),
                profileMapper.convert(user.getProfile()),
                user.isActive()
        );
    }

}