package net.vinograd.eventradar.client.presentation;

import lombok.RequiredArgsConstructor;
import net.vinograd.eventradar.client.application.cases.UserCreationUseCase;
import net.vinograd.eventradar.client.application.commands.CreateUserCommand;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserStorageController {

    private final UserCreationUseCase userCreationUseCase;

    @PostMapping("/create-user")
    void createUser(@RequestBody CreateUserCommand command) {
        userCreationUseCase.createNewUser(command);
    }

}