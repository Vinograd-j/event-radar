package net.vinograd.eventradar.profile.presentation;

import net.vinograd.eventradar.client.domain.Email;
import net.vinograd.eventradar.profile.domain.Profile;
import net.vinograd.eventradar.profile.domain.ProfileId;
import net.vinograd.eventradar.profile.infrastructure.JpaProfile;
import org.springframework.stereotype.Component;

@Component
public class ProfileMapper {

    public Profile convert(JpaProfile jpaProfile) {
        return new Profile(
                new ProfileId(jpaProfile.getId()),
                jpaProfile.getDisplayName(),
                new Email(jpaProfile.getEmail()),
                jpaProfile.getBio()
        );
    }

    public JpaProfile convert(Profile profile) {
        return new JpaProfile(
                profile.getId().getId(),
                profile.getDisplayName(),
                profile.getEmail().getEmail(),
                profile.getBio()
        );
    }

}
