package net.vinograd.eventradar.team.application.error;

import net.vinograd.eventradar.common.application.ApiError;
import net.vinograd.eventradar.team.application.error.excaption.TeamInactiveException;
import net.vinograd.eventradar.team.application.error.excaption.TeamNameOccupiedException;
import net.vinograd.eventradar.team.application.error.excaption.TeamNotFoundException;
import org.jspecify.annotations.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TeamExceptionHandler {

    @ExceptionHandler(TeamNotFoundException.class)
    public ResponseEntity<@NonNull ApiError> handleTeamNotFoundException(TeamNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError(e.getMessage()));
    }

    @ExceptionHandler(TeamInactiveException.class)
    public ResponseEntity<@NonNull ApiError> handleUserInactiveException(TeamInactiveException e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ApiError(e.getMessage()));
    }

    @ExceptionHandler(TeamNameOccupiedException.class)
    public ResponseEntity<@NonNull ApiError> handleTeamNameOccupiedException(TeamNameOccupiedException e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ApiError(e.getMessage()));
    }

}