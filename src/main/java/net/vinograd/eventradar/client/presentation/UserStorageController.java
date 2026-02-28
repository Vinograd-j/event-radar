package net.vinograd.eventradar.client.presentation;

import lombok.RequiredArgsConstructor;
import net.vinograd.eventradar.client.application.cases.UserCreationUseCase;
import net.vinograd.eventradar.client.application.cases.commands.UserCreationCommand;
import net.vinograd.eventradar.client.domain.root.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserStorageController {

    private final UserCreationUseCase userCreationUseCase;

    @PostMapping("/create-user")
    void createUser(@RequestBody UserCreationCommand command) {
        userCreationUseCase.execute(command);
    }

}