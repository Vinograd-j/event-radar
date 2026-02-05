package net.vinograd.eventradar.client.presentation;

import lombok.RequiredArgsConstructor;
import net.vinograd.eventradar.client.application.cases.ProfileModificationUseCase;
import net.vinograd.eventradar.client.application.commands.DisplayNameModificationCommand;
import net.vinograd.eventradar.client.application.commands.ProfileBioModificationCommand;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProfileModificationController {

    private final ProfileModificationUseCase profileModificationUseCase;

    @PostMapping("/change-profile-bio")
    void changeBio(ProfileBioModificationCommand command) {
        profileModificationUseCase.changeBio(command);
    }

    @PostMapping("/change-display-name")
    void changeBio(DisplayNameModificationCommand command) {
        profileModificationUseCase.changeDisplayName(command);
    }

}