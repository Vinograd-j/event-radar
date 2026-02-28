package net.vinograd.eventradar.client.application.cases;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.vinograd.eventradar.client.application.cases.commands.UserActivationCommand;
import net.vinograd.eventradar.client.application.error.UserError;
import net.vinograd.eventradar.client.application.port.UserRepository;
import net.vinograd.eventradar.client.domain.root.User;
import net.vinograd.eventradar.common.application.Result;
import net.vinograd.eventradar.common.application.UseCase;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserActivationUseCase implements UseCase<UserActivationCommand, User> {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public Result<User> execute(UserActivationCommand command) {
        Optional<User> user = this.userRepository.findById(command.userId());

        if (user.isEmpty())
            return Result.failure(UserError.NOT_FOUND);

        if (command.activated()) {
            user.get().activate();
        } else {
            user.get().deactivate();
        }

        return Result.success(user.get());
    }

}