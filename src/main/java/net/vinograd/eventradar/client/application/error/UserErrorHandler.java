package net.vinograd.eventradar.client.application.error;

import net.vinograd.eventradar.common.application.Error;
import net.vinograd.eventradar.common.presentation.AbstractErrorHandler;
import org.jspecify.annotations.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class UserErrorHandler extends AbstractErrorHandler {

    public void handle(@NonNull Error error) {
        if (error instanceof UserError) {
            handle((UserError) error);
        } else {
            throw new IllegalArgumentException("Unexpected error type: " + error);
        }
    }

    private void handle(UserError error) {
        switch (error) {
            case UserError.NOT_FOUND -> setResponse(HttpStatus.NOT_FOUND);
            case UserError.ALREADY_EXISTS -> setResponse(HttpStatus.CONFLICT);
        }
    }

}