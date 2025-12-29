package net.vinograd.eventradar.team.infrastructure;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import net.vinograd.eventradar.team.application.TeamRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class TeamRepositoryImpl implements TeamRepository {

    private JpaTeamRepository teamRepository;

    @Override
    public boolean existById(@NonNull UUID teamId) {
        return this.teamRepository.existsById(teamId);
    }

    @Override
    public Optional<JpaTeam> findById(@NonNull UUID teamId) {
        return this.teamRepository.findById(teamId);
    }

    @Override
    public void save(@NonNull JpaTeam team) {
        this.teamRepository.save(team);
    }

}