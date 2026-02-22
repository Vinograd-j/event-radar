package net.vinograd.eventradar.client.application.cases.commands;

import java.util.UUID;

public record DisplayNameModificationCommand(UUID id, String displayName) { }