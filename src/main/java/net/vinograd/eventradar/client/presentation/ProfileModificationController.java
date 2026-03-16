package net.vinograd.eventradar.client.presentation;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.vinograd.eventradar.client.application.cases.ProfileModificationUseCase;
import net.vinograd.eventradar.client.application.cases.commands.ProfileModificationCommand;
import net.vinograd.eventradar.client.domain.root.Profile;
import net.vinograd.eventradar.common.application.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProfileModificationController {

    private final ProfileModificationUseCase profileModificationUseCase;

    @PostMapping("/changeProfileDescription")
    ResponseEntity<@NonNull Profile> changeProfileDescription(ProfileModificationCommand command) {
        Result<Profile> result = profileModificationUseCase.execute(command);

        if (!result.isSuccess())
            throw result.getException();

        return ResponseEntity.ok(result.getValue());
    }

}