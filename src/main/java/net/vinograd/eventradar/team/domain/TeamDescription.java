package net.vinograd.eventradar.team.domain;

import lombok.Getter;

@Getter
public class TeamDescription {

    private final String teamName;

    private final String teamBio;

    public TeamDescription(String teamName, String teamBio) {
        if (!isValid(teamName))
            throw new IllegalArgumentException("Team name is invalid");

        this.teamName = teamName;
        this.teamBio = teamBio;
    }

    private boolean isValid(String teamName) {
        return teamName != null && !teamName.isBlank() && teamName.matches("^[a-z]+$");
    }

    @Override
    public String toString() {
        return teamName + " " + teamBio;
    }
}
