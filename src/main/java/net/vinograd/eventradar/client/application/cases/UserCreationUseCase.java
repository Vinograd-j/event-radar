package net.vinograd.eventradar.client.application.cases;

import lombok.RequiredArgsConstructor;
import net.vinograd.eventradar.client.application.commands.CreateUserCommand;
import net.vinograd.eventradar.client.application.exception.LoginOccupiedException;
import net.vinograd.eventradar.client.application.port.UserRepository;
import net.vinograd.eventradar.client.domain.attendant.Login;
import net.vinograd.eventradar.client.domain.root.Profile;
import net.vinograd.eventradar.client.domain.root.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCreationUseCase {

    private final UserRepository userRepository;

    public void createNewUser(CreateUserCommand createUserCommand) {
        if (userRepository.existByLogin(createUserCommand.login()))
            throw new LoginOccupiedException("User already exists");

        User user = User.create(new Login(createUserCommand.login()), createUserCommand.email(),
                Profile.defaultProfile(createUserCommand.displayName(),
                        createUserCommand.firstName(),
                        createUserCommand.lastName()));

        this.userRepository.save(user);
    }

}