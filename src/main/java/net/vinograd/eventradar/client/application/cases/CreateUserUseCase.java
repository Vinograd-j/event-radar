package net.vinograd.eventradar.client.application.cases;

import lombok.RequiredArgsConstructor;
import net.vinograd.eventradar.client.application.exception.LoginOccupiedException;
import net.vinograd.eventradar.client.application.port.UserRepository;
import net.vinograd.eventradar.client.domain.root.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserUseCase {

    private final UserRepository userRepository;

    public void createNewUser(User user) {
        if (userRepository.findById(user.getId()).isPresent())
            throw new IllegalStateException("User already exists");

        if (userRepository.existByLogin(user.getLogin().value()))
            throw new LoginOccupiedException("User already exists");

        this.userRepository.save(user);
    }

}