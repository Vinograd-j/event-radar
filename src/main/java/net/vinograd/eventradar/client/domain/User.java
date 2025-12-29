package net.vinograd.eventradar.client.domain;

import lombok.Getter;
import net.vinograd.eventradar.profile.domain.Profile;
import net.vinograd.eventradar.team.domain.Team;

import java.util.HashSet;
import java.util.Set;

@Getter
public class User {

    private final UserId id;

    private final Username username;

    private final Profile profile;

    private final Set<Team> teams;

    private boolean isActive;

    public User(UserId id, Username username, Profile profile, boolean isActive) {
        this.id = id;
        this.username = username;
        this.profile = profile;
        this.teams = new HashSet<>();
        this.isActive = isActive;
    }

    public User(UserId id, Username username, Profile profile, Set<Team> teams, boolean isActive) {
        this.id = id;
        this.username = username;
        this.profile = profile;
        this.teams = teams;
        this.isActive = isActive;
    }

    public void activate() {
        this.isActive = true;
    }

    public void deactivate() {
        this.isActive = false;
    }

    public void addTeam(Team team) {
        this.teams.add(team);
    }

    public void removeTeam(Team team) {
        this.teams.remove(team);
    }

}