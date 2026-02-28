package net.vinograd.eventradar.team.application.cases;

import lombok.RequiredArgsConstructor;
import net.vinograd.eventradar.common.application.Result;
import net.vinograd.eventradar.common.application.UseCase;
import net.vinograd.eventradar.team.application.cases.commands.TeamDescriptionModificationCommand;
import net.vinograd.eventradar.team.application.port.TeamRepository;
import net.vinograd.eventradar.team.domain.Team;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamModificationUseCase implements UseCase<TeamDescriptionModificationCommand, Team> {

    private final TeamRepository teamRepository;

    @Override
    public Result<Team> execute(TeamDescriptionModificationCommand command) {
        Team team = teamRepository.findById(command.teamId()).orElseThrow();

        team.changeDesctiption(command.teamDescription());

        teamRepository.save(team);

        return Result.success(team);
    }

}