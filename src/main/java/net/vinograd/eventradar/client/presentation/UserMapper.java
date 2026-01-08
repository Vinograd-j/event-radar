package net.vinograd.eventradar.client.presentation;

import net.vinograd.eventradar.client.domain.Login;
import net.vinograd.eventradar.client.domain.User;
import net.vinograd.eventradar.client.domain.Username;
import net.vinograd.eventradar.client.infrastructure.JpaUser;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User convert(JpaUser jpaUser) {
        return new User(
                jpaUser.getId(),
                new Login(jpaUser.getLogin()),
                new Username(jpaUser.getName(), jpaUser.getLastName()),
                jpaUser.getProfile().getId(),
                jpaUser.isActive()
        );
    }

}
