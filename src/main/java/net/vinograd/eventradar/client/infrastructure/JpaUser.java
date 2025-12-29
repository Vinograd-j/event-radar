package net.vinograd.eventradar.client.infrastructure;

import jakarta.persistence.*;
import lombok.*;
import net.vinograd.eventradar.profile.infrastructure.JpaProfile;

import java.util.UUID;

@Entity
@ToString
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor()
@Getter
public class JpaUser {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "login", unique = true, nullable = false, updatable = false)
    private String login;

    @Column(name = "first_name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @OneToOne(fetch = FetchType.EAGER)
    private JpaProfile profile;

    private boolean isActive;

}
