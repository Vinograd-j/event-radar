package net.vinograd.eventradar.client.application.cases.commands;

public record CreateUserCommand(
        String login,
        String email,
        String displayName,
        String firstName,
        String lastName
) { }