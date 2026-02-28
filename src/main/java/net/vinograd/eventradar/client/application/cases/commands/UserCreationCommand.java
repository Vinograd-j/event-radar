package net.vinograd.eventradar.client.application.cases.commands;

public record UserCreationCommand(
        String login,
        String email,
        String displayName,
        String firstName,
        String lastName
) { }