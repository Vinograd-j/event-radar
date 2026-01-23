package net.vinograd.eventradar.team.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.vinograd.eventradar.team.domain.TeamRole;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class JpaTeamMember {

    @EmbeddedId
    private TeamMemberId id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TeamRole teamRole;

}
