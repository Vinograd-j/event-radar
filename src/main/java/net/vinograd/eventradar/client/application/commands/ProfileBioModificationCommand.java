package net.vinograd.eventradar.client.application.commands;

import java.util.UUID;

public record ProfileBioModificationCommand(UUID id, String bio) { }