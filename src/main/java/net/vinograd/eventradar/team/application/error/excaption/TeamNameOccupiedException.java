package net.vinograd.eventradar.team.application.error.excaption;

public class TeamNameOccupiedException extends RuntimeException {

    public TeamNameOccupiedException(String message) {
        super(message);
    }

}