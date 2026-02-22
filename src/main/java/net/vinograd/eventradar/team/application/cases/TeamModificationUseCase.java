package net.vinograd.eventradar.team.application.cases;

import lombok.RequiredArgsConstructor;
import net.vinograd.eventradar.team.application.cases.commands.TeamBioModificationCommand;
import net.vinograd.eventradar.team.application.cases.commands.TeamTitleModificationCommand;
import net.vinograd.eventradar.team.application.port.TeamRepository;
import net.vinograd.eventradar.team.domain.Team;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamModificationUseCase {

    private final TeamRepository teamRepository;

    public void changeTeamBio(TeamBioModificationCommand command) {
        Team team = teamRepository.findById(command.id()).orElseThrow();

        team.getDescription().changeTeamBio(command.newBio());

        teamRepository.save(team);
    }

    public void changeTeamTitle(TeamTitleModificationCommand command) {
        Team team = teamRepository.findById(command.id()).orElseThrow();

        team.getDescription().changeTeamName(command.newTitle());

        teamRepository.save(team);
    }

}