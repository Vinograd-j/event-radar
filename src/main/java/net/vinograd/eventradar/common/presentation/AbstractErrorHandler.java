package net.vinograd.eventradar.common.presentation;

import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

public abstract class AbstractErrorHandler {

    private ResponseEntity<?> response;

    @SuppressWarnings("unchecked")
    public <R> ResponseEntity<@NonNull R> getResponse() {
        if (Objects.isNull(response)) {
            throw new IllegalStateException("Could not get response: response not set");
        } else {
            return (ResponseEntity<@NonNull R>) response;
        }
    }

    protected void setResponse(@NonNull ResponseEntity<?> response) {
        validateResponseIsEmpty();
        this.response = response;
    }

    protected void setResponse(@NonNull HttpStatus status) {
        validateResponseIsEmpty();
        setResponse(ResponseEntity.status(status).build());
    }

    private void validateResponseIsEmpty() {
        if (Objects.nonNull(this.response)) {
            throw new IllegalStateException("Could not set response: response already set");
        }
    }


}