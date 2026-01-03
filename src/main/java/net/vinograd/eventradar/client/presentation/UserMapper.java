package net.vinograd.eventradar.client.presentation;

import net.vinograd.eventradar.client.domain.Login;
import net.vinograd.eventradar.client.domain.User;
import net.vinograd.eventradar.client.domain.UserId;
import net.vinograd.eventradar.client.domain.Username;
import net.vinograd.eventradar.client.infrastructure.JpaUser;
import net.vinograd.eventradar.profile.domain.ProfileId;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User convert(JpaUser jpaUser) {
        return new User(
                new UserId(jpaUser.getId(), new Login(jpaUser.getLogin())),
                new Username(jpaUser.getName(), jpaUser.getLastName()),
                new ProfileId(jpaUser.getProfile().getId()),
                jpaUser.isActive()
        );
    }

}
