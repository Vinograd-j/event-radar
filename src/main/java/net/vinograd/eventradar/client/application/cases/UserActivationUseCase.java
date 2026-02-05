package net.vinograd.eventradar.client.application.cases;

import lombok.RequiredArgsConstructor;
import net.vinograd.eventradar.client.application.port.UserRepository;
import net.vinograd.eventradar.client.domain.root.User;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserActivationUseCase {

    private final UserRepository userRepository;

    public void activate(UUID id) {
        User user = this.userRepository.findById(id).orElseThrow();
        user.activate();

        this.userRepository.save(user);
    }

    public void deactivate(UUID id) {
        User user = this.userRepository.findById(id).orElseThrow();
        user.deactivate();

        this.userRepository.save(user);
    }

}