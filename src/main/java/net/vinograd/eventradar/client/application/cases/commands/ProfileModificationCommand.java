package net.vinograd.eventradar.client.application.cases.commands;

import net.vinograd.eventradar.client.domain.attendant.ProfileDescription;

import java.util.UUID;

public record ProfileModificationCommand(UUID userId, ProfileDescription description) {

}
