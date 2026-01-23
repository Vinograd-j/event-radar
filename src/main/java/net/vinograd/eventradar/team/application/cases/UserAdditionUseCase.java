package net.vinograd.eventradar.team.application.cases;

import lombok.RequiredArgsConstructor;
import net.vinograd.eventradar.client.domain.root.User;
import net.vinograd.eventradar.team.application.TeamMemberRepository;
import net.vinograd.eventradar.team.domain.Team;
import net.vinograd.eventradar.team.infrastructure.entity.TeamMemberId;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAdditionUseCase {

    private final TeamMemberRepository teamMemberRepository;

    public void addUserToTeam(User user, Team team) {
        this.teamMemberRepository.addTeamMember(new TeamMemberId(team.getId(), user.getId()));
    }

}