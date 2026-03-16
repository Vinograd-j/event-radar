package net.vinograd.eventradar.team.presentation;

import lombok.RequiredArgsConstructor;
import net.vinograd.eventradar.common.application.Result;
import net.vinograd.eventradar.team.application.cases.TeamCreationUseCase;
import net.vinograd.eventradar.team.application.cases.commands.TeamCreationCommand;
import net.vinograd.eventradar.team.domain.Team;
import org.jspecify.annotations.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TeamStorageController {

    private final TeamCreationUseCase teamCreationUseCase;


    @PostMapping("/create-team")
    public ResponseEntity<@NonNull Team> createTeam(@RequestBody TeamCreationCommand command) {
        Result<Team> result = teamCreationUseCase.execute(command);

        if (result.isFailure())
            throw result.getException();

        return ResponseEntity.ok(result.getValue());
    }

}
