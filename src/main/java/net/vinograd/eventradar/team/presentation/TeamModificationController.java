package net.vinograd.eventradar.team.presentation;

import lombok.RequiredArgsConstructor;
import net.vinograd.eventradar.team.application.cases.TeamModificationUseCase;
import net.vinograd.eventradar.team.application.cases.UserAdditionUseCase;
import net.vinograd.eventradar.team.application.cases.commands.AdditionUserToTeamCommand;
import net.vinograd.eventradar.team.application.cases.commands.TeamDescriptionModificationCommand;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TeamModificationController {

    private final UserAdditionUseCase userAdditionUseCase;

    private final TeamModificationUseCase teamModificationUseCase;

    @PostMapping("/add-user-to-team")
    public void addUserToTeam(@RequestBody AdditionUserToTeamCommand command) {
        userAdditionUseCase.execute(command);
    }

    @PostMapping("/change-team-description")
    public void changeTeamBio(@RequestBody TeamDescriptionModificationCommand command) {
        teamModificationUseCase.execute(command);
    }

}
