package net.vinograd.eventradar.team.application.cases;

import lombok.RequiredArgsConstructor;
import net.vinograd.eventradar.team.application.port.TeamRepository;
import net.vinograd.eventradar.team.application.exception.TeamNameOccupiedException;
import net.vinograd.eventradar.team.domain.Team;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamCreationUseCase {

    private final TeamRepository teamRepository;

    public void createTeam(Team team) {
        if (teamRepository.existById(team.getId()))
            throw new IllegalArgumentException("Team id already exists");

        if (teamRepository.existByName(team.getDescription().getTeamName()))
            throw new TeamNameOccupiedException("Team name is occupied");

        teamRepository.save(team);
    }

}
