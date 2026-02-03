package net.vinograd.eventradar.team.application.cases.commands;

import java.util.UUID;

public record AdditionUserToTeamCommand(UUID teamId, UUID userId) {

}