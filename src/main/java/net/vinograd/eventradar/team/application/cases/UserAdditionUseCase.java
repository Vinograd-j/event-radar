package net.vinograd.eventradar.team.application.cases;

import lombok.RequiredArgsConstructor;
import net.vinograd.eventradar.common.application.Result;
import net.vinograd.eventradar.common.application.UseCase;
import net.vinograd.eventradar.team.application.error.TeamError;
import net.vinograd.eventradar.team.application.port.TeamMemberRepository;
import net.vinograd.eventradar.team.application.port.TeamRepository;
import net.vinograd.eventradar.team.application.cases.commands.AdditionUserToTeamCommand;
import net.vinograd.eventradar.team.domain.Team;
import net.vinograd.eventradar.team.infrastructure.entity.TeamMemberId;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAdditionUseCase implements UseCase<AdditionUserToTeamCommand, Team> {

    private final TeamMemberRepository teamMemberRepository;

    private final TeamRepository teamRepository;

    @Override
    public Result<Team> execute(AdditionUserToTeamCommand command) {
        Team team = teamRepository.findById(command.teamId()).orElseThrow();

        if (!team.isActive())
            return Result.failure(TeamError.INACTIVE);

        teamMemberRepository.addTeamMember(new TeamMemberId(command.teamId(), team.getId()));

        return Result.success(team);
    }

}