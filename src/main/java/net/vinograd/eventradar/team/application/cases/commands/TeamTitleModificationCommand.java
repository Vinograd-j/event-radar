package net.vinograd.eventradar.team.application.cases.commands;

import java.util.UUID;

public record TeamTitleModificationCommand(UUID id, String newTitle) { }