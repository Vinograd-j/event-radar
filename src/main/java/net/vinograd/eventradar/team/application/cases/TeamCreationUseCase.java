package net.vinograd.eventradar.team.application.cases;

import lombok.RequiredArgsConstructor;
import net.vinograd.eventradar.team.application.TeamRepository;
import net.vinograd.eventradar.team.domain.Team;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamCreationUseCase {

    private final TeamRepository teamRepository;

    public void createTeam(Team team) {
        teamRepository.save(team);
    }

}
