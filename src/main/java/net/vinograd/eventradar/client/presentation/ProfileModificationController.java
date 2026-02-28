package net.vinograd.eventradar.client.presentation;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.vinograd.eventradar.client.application.cases.ProfileModificationUseCase;
import net.vinograd.eventradar.client.application.cases.commands.ProfileModificationCommand;
import net.vinograd.eventradar.client.application.error.UserErrorHandler;
import net.vinograd.eventradar.client.domain.root.Profile;
import net.vinograd.eventradar.common.application.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProfileModificationController {

    private final ProfileModificationUseCase profileModificationUseCase;

    private final UserErrorHandler userErrorHandler;

    @PostMapping("/changeProfileDescription")
    ResponseEntity<@NonNull Profile> changeProfileDescription(ProfileModificationCommand command) {
        Result<Profile> value = profileModificationUseCase.execute(command);

        return convertResultToResponse(value);
    }

    public ResponseEntity<@NonNull Profile> convertResultToResponse(Result<Profile> result) {
        if (result.isSuccess())
            return ResponseEntity.ok(result.getValue());

        return handleError(result);
    }

    public ResponseEntity<@NonNull Profile> handleError(Result<Profile> result) {
        userErrorHandler.handle(result.getError());
        return userErrorHandler.getResponse();
    }

}