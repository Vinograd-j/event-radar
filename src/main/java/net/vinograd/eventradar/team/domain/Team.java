package net.vinograd.eventradar.team.domain;

import lombok.Getter;
import net.vinograd.eventradar.client.domain.UserId;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Team {

    private final TeamId id;

    private final TeamDescription description;

    private final Set<UserId> participants;

    private boolean isActive;

    public Team(TeamId id, TeamDescription teamName, UserId owner) {
        this.id = id;
        this.description = teamName;
        this.participants = new HashSet<>();
        this.isActive = true;

        participants.add(owner);
    }

    public void deactivate() {
        this.isActive = false;
    }

    public void activate() {
        this.isActive = true;
    }

    public void addParticipant(UserId userId) {
        this.participants.add(userId);
    }

    public void removeParticipant(UserId userId) {
        this.participants.remove(userId);
    }

}
