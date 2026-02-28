package net.vinograd.eventradar.client.application.cases;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.vinograd.eventradar.client.application.cases.commands.UserActivationCommand;
import net.vinograd.eventradar.client.application.port.UserRepository;
import net.vinograd.eventradar.client.domain.root.User;
import net.vinograd.eventradar.common.application.Result;
import net.vinograd.eventradar.common.application.UseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserActivationUseCase implements UseCase<UserActivationCommand, User> {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public Result<User> execute(UserActivationCommand command) {
        User user = this.userRepository.findById(command.userId()).orElseThrow();

        if (command.activated()) {
            user.activate();
        } else {
            user.deactivate();
        }

        return Result.success(user);
    }

}