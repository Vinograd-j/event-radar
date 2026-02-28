package net.vinograd.eventradar.team.presentation;

import lombok.RequiredArgsConstructor;
import net.vinograd.eventradar.team.application.cases.TeamCreationUseCase;
import net.vinograd.eventradar.team.application.cases.commands.TeamCreationCommand;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TeamStorageController {

    private final TeamCreationUseCase teamCreationUseCase;

    @PostMapping("/create-team")
    public void createTeam(@RequestBody TeamCreationCommand command) {
        teamCreationUseCase.execute(command);
    }

}
