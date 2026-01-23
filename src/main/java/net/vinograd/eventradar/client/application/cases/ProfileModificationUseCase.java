package net.vinograd.eventradar.client.application.cases;

import lombok.RequiredArgsConstructor;
import net.vinograd.eventradar.client.application.port.UserRepository;
import net.vinograd.eventradar.client.domain.root.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileModificationUseCase {

    private final UserRepository userRepository;

    public void changeBio(User user, String newBio) {
        user.getProfile().changeBio(newBio);
        this.userRepository.save(user);
    }

    public void changeDisplayName(User user, String newDisplayName) {
        user.getProfile().changeDisplayName(newDisplayName);
        this.userRepository.save(user);
    }

}
