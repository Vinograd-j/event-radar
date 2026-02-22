package net.vinograd.eventradar.team.application.cases.commands;

import java.util.UUID;

public record TeamBioModificationCommand(UUID id, String newBio) { }