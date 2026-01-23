package net.vinograd.eventradar.team.infrastructure.repository;


import lombok.AllArgsConstructor;
import lombok.NonNull;
import net.vinograd.eventradar.client.domain.root.User;
import net.vinograd.eventradar.client.infrastructure.mapper.UserMapper;
import net.vinograd.eventradar.client.infrastructure.repository.JpaUserRepository;
import net.vinograd.eventradar.team.application.TeamMemberRepository;
import net.vinograd.eventradar.team.domain.Team;
import net.vinograd.eventradar.team.domain.TeamRole;
import net.vinograd.eventradar.team.infrastructure.entity.JpaTeamMember;
import net.vinograd.eventradar.team.infrastructure.entity.TeamMemberId;
import net.vinograd.eventradar.team.infrastructure.mapper.TeamMapper;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@Repository
public class TeamMemberRepositoryImpl implements TeamMemberRepository {

    private final JpaTeamMemberRepository teamMemberRepository;

    private final JpaTeamRepository teamRepository;

    private final JpaUserRepository userRepository;

    private final TeamMapper teamMapper;

    private final UserMapper userMapper;

    @Override
    public Set<Team> findAllUserTeams(@NonNull UUID memberId) {
        Set<UUID> teamIds = teamMemberRepository.findAllByIdUserId(memberId).stream()
                .map(tm -> tm.getId().getTeamId())
                .collect(Collectors.toSet());

        return teamRepository.findAllById(teamIds).stream().map(teamMapper::convert).collect(Collectors.toSet());
    }

    @Override
    public Set<User> findAllTeamMembers(@NonNull UUID teamId) {
        Set<UUID> userIds = teamMemberRepository.findAllByIdTeamId(teamId).stream()
                .map(tm -> tm.getId().getUserId())
                .collect(Collectors.toSet());

        return userRepository.findAllById(userIds).stream().map(userMapper::convert).collect(Collectors.toSet());
    }

    @Override
    public void deleteTeamMember(TeamMemberId teamMemberId) {
        teamMemberRepository.deleteById(teamMemberId);
    }

    @Override
    public void addTeamMember(TeamMemberId teamMemberId){
        teamMemberRepository.save(new JpaTeamMember(teamMemberId, TeamRole.PARTICIPANT));
    }

}