package net.vinograd.eventradar.client.application.commands;

import java.util.UUID;

public record DisplayNameModificationCommand(UUID id, String displayName) { }