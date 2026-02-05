package net.vinograd.eventradar.client.application.cases;

import lombok.RequiredArgsConstructor;
import net.vinograd.eventradar.client.application.commands.DisplayNameModificationCommand;
import net.vinograd.eventradar.client.application.commands.ProfileBioModificationCommand;
import net.vinograd.eventradar.client.application.port.UserRepository;
import net.vinograd.eventradar.client.domain.root.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileModificationUseCase {

    private final UserRepository userRepository;

    public void changeBio(ProfileBioModificationCommand command) {
        User user = this.userRepository.findById(command.id()).orElseThrow();

        user.getProfile().changeBio(command.bio());

        this.userRepository.save(user);
    }

    public void changeDisplayName(DisplayNameModificationCommand command) {
        User user = this.userRepository.findById(command.id()).orElseThrow();

        user.getProfile().changeDisplayName(command.displayName());

        this.userRepository.save(user);
    }

}