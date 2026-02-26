package net.vinograd.eventradar.client.infrastructure.mapper;

import net.vinograd.eventradar.client.domain.root.Profile;
import net.vinograd.eventradar.client.infrastructure.entities.JpaProfile;
import org.springframework.stereotype.Component;

@Component
public class ProfileMapper {

    public Profile convert(JpaProfile jpaProfile) {
        return Profile.restore(
                jpaProfile.getDisplayName(),
                jpaProfile.getFirstName(),
                jpaProfile.getLastName(),
                jpaProfile.getBio()
        );
    }

    public JpaProfile convert(Profile profile) {
        return new JpaProfile(
                profile.getDescription().getDisplayName(),
                profile.getUsername().getFirstName(),
                profile.getUsername().getLastName(),
                profile.getDescription().getBio()
        );
    }

}
