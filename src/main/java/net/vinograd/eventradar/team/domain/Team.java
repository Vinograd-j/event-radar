package net.vinograd.eventradar.team.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.vinograd.eventradar.client.domain.User;
import net.vinograd.eventradar.client.domain.UserId;

import java.util.Set;

@Getter
@AllArgsConstructor
public class Team {

    private final TeamId id;

    private final TeamDescription description;

    private final Set<User> participants;

    private boolean isActive;

    public void deactivate() {
        this.isActive = false;
    }

    public void activate() {
        this.isActive = true;
    }

    public void addParticipant(User user) {
        this.participants.add(user);
    }

    public void removeParticipant(UserId userId) {
        this.participants.remove(userId);
    }

}
