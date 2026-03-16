package net.vinograd.eventradar.team.application.error.excaption;

public class TeamInactiveException extends RuntimeException {

    public TeamInactiveException(String message) {
        super(message);
    }

}
