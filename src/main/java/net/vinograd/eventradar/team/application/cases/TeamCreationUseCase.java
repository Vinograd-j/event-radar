package net.vinograd.eventradar.team.application.cases;

import lombok.RequiredArgsConstructor;
import net.vinograd.eventradar.team.application.cases.commands.CreateTeamCommand;
import net.vinograd.eventradar.team.application.port.TeamRepository;
import net.vinograd.eventradar.team.application.exception.TeamNameOccupiedException;
import net.vinograd.eventradar.team.domain.Team;
import net.vinograd.eventradar.team.domain.TeamDescription;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamCreationUseCase {

    private final TeamRepository teamRepository;

    public void createTeam(CreateTeamCommand command) {
        if (teamRepository.existByName(command.teamName()))
            throw new TeamNameOccupiedException("Team name is occupied");

        Team team = Team.create(new TeamDescription(command.teamName(), command.bio()));

        teamRepository.save(team);
    }

}
