package net.vinograd.eventradar.team.application.error;

import net.vinograd.eventradar.common.presentation.AbstractErrorHandler;
import net.vinograd.eventradar.common.application.Error;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class TeamErrorHandler extends AbstractErrorHandler {

    public void handle(Error error) {
        if (error instanceof TeamError) {
            handle((TeamError) error);
        } else {
            throw new IllegalArgumentException("Unexpected error type: " + error);
        }
    }

    private void handle(TeamError error) {
        switch (error){
            case TeamError.NOT_FOUND -> setResponse(HttpStatus.NOT_FOUND);
            case TeamError.NAME_OCCUPIED -> setResponse(HttpStatus.BAD_REQUEST);
            case TeamError.INACTIVE -> setResponse(HttpStatus.FORBIDDEN);
        }
    }

}