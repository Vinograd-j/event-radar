package net.vinograd.eventradar.team.application.error.excaption;

public class TeamNotFoundException extends RuntimeException {

    public TeamNotFoundException(String message) {
        super(message);
    }

}
