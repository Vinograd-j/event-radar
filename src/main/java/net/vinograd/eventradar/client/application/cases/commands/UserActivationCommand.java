package net.vinograd.eventradar.client.application.cases.commands;

import java.util.UUID;

public record UserActivationCommand(UUID userId, boolean activated) {

}