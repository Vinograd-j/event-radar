package net.vinograd.eventradar.client.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@ToString
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class JpaUser {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "login", unique = true, nullable = false, updatable = false)
    private String login;
    
    @Column(name = "email")
    private String email;

    @Embedded
    private JpaProfile profile;

    private boolean isActive;

}
