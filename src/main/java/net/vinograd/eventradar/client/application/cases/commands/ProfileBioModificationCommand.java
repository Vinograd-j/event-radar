package net.vinograd.eventradar.client.application.cases.commands;

import java.util.UUID;

public record ProfileBioModificationCommand(UUID id, String bio) { }