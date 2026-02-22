package net.vinograd.eventradar.team.presentation;

import lombok.RequiredArgsConstructor;
import net.vinograd.eventradar.team.application.cases.TeamModificationUseCase;
import net.vinograd.eventradar.team.application.cases.UserAdditionUseCase;
import net.vinograd.eventradar.team.application.cases.commands.AdditionUserToTeamCommand;
import net.vinograd.eventradar.team.application.cases.commands.TeamBioModificationCommand;
import net.vinograd.eventradar.team.application.cases.commands.TeamTitleModificationCommand;
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
        userAdditionUseCase.addUserToTeam(command);
    }

    @PostMapping("/change-team-bio")
    public void changeTeamBio(@RequestBody TeamBioModificationCommand command) {
        teamModificationUseCase.changeTeamBio(command);
    }

    @PostMapping("/change-team-title")
    public void changeTeamTitle(@RequestBody TeamTitleModificationCommand command) {
        teamModificationUseCase.changeTeamTitle(command);
    }

}
