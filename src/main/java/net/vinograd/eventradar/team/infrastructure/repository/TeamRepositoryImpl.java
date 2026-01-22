package net.vinograd.eventradar.team.infrastructure.repository;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import net.vinograd.eventradar.team.application.TeamRepository;
import net.vinograd.eventradar.team.domain.Team;
import net.vinograd.eventradar.team.infrastructure.mapper.TeamMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class TeamRepositoryImpl implements TeamRepository {

    private final JpaTeamRepository teamRepository;

    private final TeamMapper teamMapper;

    @Override
    public boolean existById(@NonNull UUID teamId) {
        return this.teamRepository.existsById(teamId);
    }

    @Override
    public Optional<Team> findById(@NonNull UUID teamId) {
        return this.teamRepository.findById(teamId).map(teamMapper::convert);
    }

    @Override
    public void save(@NonNull Team team) {
        this.teamRepository.save(teamMapper.convert(team));
    }

}