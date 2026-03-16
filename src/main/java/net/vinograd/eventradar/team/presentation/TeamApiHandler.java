package net.vinograd.eventradar.team.presentation;

import lombok.RequiredArgsConstructor;
import net.vinograd.eventradar.common.application.Result;
import net.vinograd.eventradar.team.application.error.TeamErrorHandler;
import net.vinograd.eventradar.team.domain.Team;
import org.jspecify.annotations.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeamApiHandler {

    private final TeamErrorHandler teamErrorHandler;

    protected ResponseEntity<@NonNull Team> convertResultToResponseEntity(Result<@NonNull Team> result) {
        if (result.isSuccess())
            return ResponseEntity.ok(result.getValue());

        return handleError(result);
    }

    private ResponseEntity<@NonNull Team> handleError(Result<@NonNull Team> result) {
        teamErrorHandler.handle(result.getException());
        return teamErrorHandler.getResponse();
    }

}
