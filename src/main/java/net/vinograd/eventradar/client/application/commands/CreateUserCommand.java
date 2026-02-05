package net.vinograd.eventradar.client.application.commands;

public record CreateUserCommand(
        String login,
        String email,
        String displayName,
        String firstName,
        String lastName
) { }