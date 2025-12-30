package net.vinograd.eventradar.client.presentation;

import lombok.AllArgsConstructor;
import net.vinograd.eventradar.client.domain.Login;
import net.vinograd.eventradar.client.domain.User;
import net.vinograd.eventradar.client.domain.UserId;
import net.vinograd.eventradar.client.domain.Username;
import net.vinograd.eventradar.client.infrastructure.JpaUser;
import net.vinograd.eventradar.profile.presentation.ProfileMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserMapper {

    private ProfileMapper profileMapper;

    public User convert(JpaUser jpaUser) {
        return new User(
                new UserId(jpaUser.getId(), new Login(jpaUser.getLogin())),
                new Username(jpaUser.getName(), jpaUser.getLastName()),
                profileMapper.convert(jpaUser.getProfile()),
                jpaUser.isActive()
        );
    }

    public JpaUser convert(User user) {
        return new JpaUser(
                user.getId().getId(),
                user.getId().getLogin().getLogin(),
                user.getUsername().getFirstName(),
                user.getUsername().getLastName(),
                profileMapper.convert(user.getProfile()),
                user.isActive()
        );

    }

}
