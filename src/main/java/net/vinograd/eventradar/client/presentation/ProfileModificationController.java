package net.vinograd.eventradar.client.presentation;

import lombok.RequiredArgsConstructor;
import net.vinograd.eventradar.client.application.cases.ProfileModificationUseCase;
import net.vinograd.eventradar.client.application.cases.commands.ProfileModificationCommand;
import net.vinograd.eventradar.client.domain.root.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProfileModificationController {

    private final ProfileModificationUseCase profileModificationUseCase;

    @PostMapping("/change-profile-bio")
    ResponseEntity<Profile> changeProfileDescription(ProfileModificationCommand command) {
        Profile value = profileModificationUseCase.execute(command).getValue();

        return ResponseEntity.ok(value);
    }

}