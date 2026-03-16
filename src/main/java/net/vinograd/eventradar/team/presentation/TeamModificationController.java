package net.vinograd.eventradar.team.presentation;

import lombok.RequiredArgsConstructor;
import net.vinograd.eventradar.common.application.Result;
import net.vinograd.eventradar.team.application.cases.TeamModificationUseCase;
import net.vinograd.eventradar.team.application.cases.UserAdditionUseCase;
import net.vinograd.eventradar.team.application.cases.commands.AdditionUserToTeamCommand;
import net.vinograd.eventradar.team.application.cases.commands.TeamDescriptionModificationCommand;
import net.vinograd.eventradar.team.domain.Team;
import org.jspecify.annotations.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TeamModificationController {

    private final UserAdditionUseCase userAdditionUseCase;

    private final TeamModificationUseCase teamModificationUseCase;


    @PostMapping("/addUserToTeam")
    public ResponseEntity<@NonNull Team> addUserToTeam(@RequestBody AdditionUserToTeamCommand command) {
        Result<Team> result = userAdditionUseCase.execute(command);

        if (result.isFailure())
            throw result.getException();

        return ResponseEntity.ok(result.getValue());
    }

    @PostMapping("/changeTeamDescription")
    public ResponseEntity<@NonNull Team> changeTeamBio(@RequestBody TeamDescriptionModificationCommand command) {
        Result<Team> result = teamModificationUseCase.execute(command);

        if (result.isFailure())
            throw result.getException();

        return ResponseEntity.ok(result.getValue());
    }

}