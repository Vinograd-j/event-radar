package net.vinograd.eventradar.client.presentation;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.vinograd.eventradar.client.application.cases.UserCreationUseCase;
import net.vinograd.eventradar.client.application.cases.commands.UserCreationCommand;
import net.vinograd.eventradar.client.domain.root.User;
import net.vinograd.eventradar.common.application.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserStorageController {

    private final UserCreationUseCase userCreationUseCase;

    @PostMapping("/createUser")
    ResponseEntity<@NonNull User> createUser(@RequestBody UserCreationCommand command) {
        Result<User> result = userCreationUseCase.execute(command);

        if (!result.isSuccess())
            throw result.getException();

        return ResponseEntity.ok(result.getValue());
    }

}