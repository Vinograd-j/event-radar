package net.vinograd.eventradar.client.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class UserId {

    private final UUID id;

    private final Login login;

}