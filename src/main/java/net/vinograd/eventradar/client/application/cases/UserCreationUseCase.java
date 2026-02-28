package net.vinograd.eventradar.client.application.cases;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.vinograd.eventradar.client.application.cases.commands.UserCreationCommand;
import net.vinograd.eventradar.client.application.error.UserError;
import net.vinograd.eventradar.client.application.port.UserRepository;
import net.vinograd.eventradar.client.domain.attendant.Login;
import net.vinograd.eventradar.client.domain.root.Profile;
import net.vinograd.eventradar.client.domain.root.User;
import net.vinograd.eventradar.common.application.Result;
import net.vinograd.eventradar.common.application.UseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCreationUseCase implements UseCase<UserCreationCommand, User> {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public Result<User> execute(UserCreationCommand command) {
        if (userRepository.existByLogin(command.login())) {
            return Result.failure(UserError.ALREADY_EXISTS);
        }

        User user = User.create(new Login(command.login()), command.email(),
                Profile.defaultProfile(command.displayName(),
                        command.firstName(),
                        command.lastName()));

        this.userRepository.save(user);

        return Result.success(user);
    }

}