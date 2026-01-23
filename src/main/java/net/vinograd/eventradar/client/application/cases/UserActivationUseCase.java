package net.vinograd.eventradar.client.application.cases;

import lombok.RequiredArgsConstructor;
import net.vinograd.eventradar.client.application.port.UserRepository;
import net.vinograd.eventradar.client.domain.root.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserActivationUseCase {

    private final UserRepository userRepository;

    public void activateUser(User user) {
        user.activate();
        this.userRepository.save(user);
    }

    public void deactivateUser(User user) {
        user.deactivate();
        this.userRepository.save(user);
    }

}
