package net.vinograd.eventradar.team.application.cases;

import lombok.RequiredArgsConstructor;
import net.vinograd.eventradar.team.application.port.TeamMemberRepository;
import net.vinograd.eventradar.team.application.port.TeamRepository;
import net.vinograd.eventradar.team.application.cases.commands.AdditionUserToTeamCommand;
import net.vinograd.eventradar.team.application.exception.TeamBlockedException;
import net.vinograd.eventradar.team.domain.Team;
import net.vinograd.eventradar.team.infrastructure.entity.TeamMemberId;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAdditionUseCase {

    private final TeamMemberRepository teamMemberRepository;

    private final TeamRepository teamRepository;

    public void addUserToTeam(AdditionUserToTeamCommand command) {
        Team team = teamRepository.findById(command.teamId()).orElseThrow();

        if (!team.isActive())
            throw new TeamBlockedException("the team is blocked! User cannot be added");

        teamMemberRepository.addTeamMember(new TeamMemberId(command.teamId(), team.getId()));
    }

}