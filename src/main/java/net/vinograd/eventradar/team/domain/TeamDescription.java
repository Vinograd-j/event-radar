package net.vinograd.eventradar.team.domain;

import lombok.Getter;

@Getter
public class TeamDescription {

    private String teamName;

    private String teamBio;

    public TeamDescription(String teamName, String teamBio) {
        if (!isValid(teamName))
            throw new IllegalArgumentException("Team name is invalid");

        this.teamName = teamName;
        this.teamBio = teamBio;
    }

    private boolean isValid(String teamName) {
        return teamName != null && !teamName.isBlank() && teamName.matches("^[a-z]+$");
    }

    public void changeTeamName(String teamName) {
        if (!isValid(teamName))
            throw new IllegalArgumentException("Team name is invalid");
        this.teamName = teamName;
    }

    public void changeTeamBio(String teamBio) {
        this.teamBio = teamBio;
    }

    @Override
    public String toString() {
        return teamName + " " + teamBio;
    }
}
