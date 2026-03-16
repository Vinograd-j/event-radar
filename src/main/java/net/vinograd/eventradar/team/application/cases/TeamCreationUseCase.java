package net.vinograd.eventradar.team.application.cases;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.vinograd.eventradar.common.application.Result;
import net.vinograd.eventradar.common.application.UseCase;
import net.vinograd.eventradar.team.application.cases.commands.TeamCreationCommand;
import net.vinograd.eventradar.team.application.error.excaption.TeamNameOccupiedException;
import net.vinograd.eventradar.team.application.port.TeamRepository;
import net.vinograd.eventradar.team.domain.Team;
import net.vinograd.eventradar.team.domain.TeamDescription;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamCreationUseCase implements UseCase<TeamCreationCommand, Team> {

    private final TeamRepository teamRepository;

    @Transactional
    @Override
    public Result<Team> execute(TeamCreationCommand command) {

        if (teamRepository.existByName(command.teamName())){
            return Result.failure(new TeamNameOccupiedException("Name " + command.teamName() + " is occupied"));
        }

        Team team = Team.create(new TeamDescription(command.teamName(), command.bio()));

        teamRepository.save(team);

        return Result.success(team);
    }

}