package net.vinograd.eventradar.team.application.cases.commands;

import net.vinograd.eventradar.team.domain.TeamDescription;

import java.util.UUID;

public record TeamDescriptionModificationCommand(UUID teamId, TeamDescription teamDescription) {

}