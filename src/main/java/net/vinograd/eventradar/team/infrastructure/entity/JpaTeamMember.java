package net.vinograd.eventradar.team.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.vinograd.eventradar.client.infrastructure.JpaUser;
import net.vinograd.eventradar.team.domain.TeamRole;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class JpaTeamMember {

    @EmbeddedId
    private TeamMemberId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("teamId")
    @JoinColumn(name = "team_id")
    private JpaTeam team;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private JpaUser user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TeamRole teamRole;

}
