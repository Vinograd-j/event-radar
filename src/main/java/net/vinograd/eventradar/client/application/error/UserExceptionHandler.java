package net.vinograd.eventradar.client.application.error;

import net.vinograd.eventradar.client.application.error.exception.UserAlreadyExistsException;
import net.vinograd.eventradar.client.application.error.exception.UserInactiveException;
import net.vinograd.eventradar.client.application.error.exception.UserNotFoundException;
import net.vinograd.eventradar.common.application.ApiError;
import org.jspecify.annotations.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<@NonNull ApiError> handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiError(e.getMessage()));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<@NonNull ApiError> handleUserNotFoundException(UserNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError(e.getMessage()));
    }

    @ExceptionHandler(UserInactiveException.class)
    public ResponseEntity<@NonNull ApiError> handleUserInactiveException(UserInactiveException e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ApiError(e.getMessage()));
    }

}
