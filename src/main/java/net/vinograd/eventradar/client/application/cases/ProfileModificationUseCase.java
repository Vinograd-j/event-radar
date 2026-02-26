package net.vinograd.eventradar.client.application.cases;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.vinograd.eventradar.client.application.cases.commands.ProfileModificationCommand;
import net.vinograd.eventradar.client.application.port.UserRepository;
import net.vinograd.eventradar.client.domain.root.Profile;
import net.vinograd.eventradar.client.domain.root.User;
import net.vinograd.eventradar.common.application.Result;
import net.vinograd.eventradar.common.application.UseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileModificationUseCase implements UseCase<ProfileModificationCommand, Profile> {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public Result<Profile> execute(ProfileModificationCommand command) {
        User user = this.userRepository.findById(command.userId()).orElseThrow();

        user.getProfile().changeProfileDescription(command.description());

        this.userRepository.save(user);

        return Result.success(user.getProfile());
    }

}