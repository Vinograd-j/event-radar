package net.vinograd.eventradar.client.application.cases;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.vinograd.eventradar.client.application.cases.commands.ProfileModificationCommand;
import net.vinograd.eventradar.client.application.error.UserError;
import net.vinograd.eventradar.client.application.port.UserRepository;
import net.vinograd.eventradar.client.domain.root.Profile;
import net.vinograd.eventradar.client.domain.root.User;
import net.vinograd.eventradar.common.application.Result;
import net.vinograd.eventradar.common.application.UseCase;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileModificationUseCase implements UseCase<ProfileModificationCommand, Profile> {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public Result<Profile> execute(ProfileModificationCommand command) {
        Optional<User> userOptional = this.userRepository.findById(command.userId());

        if (userOptional.isEmpty())
            return Result.failure(UserError.NOT_FOUND);

        User user = userOptional.get();

        if (!user.isActive())
            return Result.failure(UserError.INACTIVE);

        user.getProfile().changeProfileDescription(command.description());

        this.userRepository.save(user);

        return Result.success(user.getProfile());
    }

}