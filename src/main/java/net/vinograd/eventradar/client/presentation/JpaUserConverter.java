package net.vinograd.eventradar.client.presentation;

import lombok.AllArgsConstructor;
import net.vinograd.eventradar.client.domain.Login;
import net.vinograd.eventradar.client.domain.User;
import net.vinograd.eventradar.client.domain.UserId;
import net.vinograd.eventradar.client.domain.Username;
import net.vinograd.eventradar.client.infrastructure.JpaUser;
import net.vinograd.eventradar.profile.domain.Profile;
import net.vinograd.eventradar.profile.infrastructure.JpaProfile;
import net.vinograd.eventradar.profile.presentation.JpaProfileConverter;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JpaUserConverter {

    private JpaProfileConverter jpaProfileConverter;

    public User convert(JpaUser jpaUser, JpaProfile jpaProfile) {
        return new User(
                new UserId(jpaUser.getId(), new Login(jpaUser.getLogin())),
                new Username(jpaUser.getName(), jpaUser.getLastName()),
                jpaProfileConverter.convert(jpaProfile),
                jpaUser.isActive()

        );
    }

    public JpaUser convert(User user, Profile profile) {
        return new JpaUser(
                user.getId().getId(),
                user.getId().getLogin().getLogin(),
                user.getUsername().getFirstName(),
                user.getUsername().getLastName(),
                jpaProfileConverter.convert(profile),
                user.isActive()
        );

    }

}
