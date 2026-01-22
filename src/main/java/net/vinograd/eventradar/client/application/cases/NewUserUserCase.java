package net.vinograd.eventradar.client.application.cases;

import lombok.AllArgsConstructor;
import net.vinograd.eventradar.client.domain.root.User;
import net.vinograd.eventradar.client.infrastructure.reposiroty.UserRepositoryImpl;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NewUserUserCase {

    private final UserRepositoryImpl userRepository;

    public void createNewUser(User user) {
        if (userRepository.findById(user.getId()).isPresent())
            throw new IllegalStateException("User already exists");

        this.userRepository.save(user);
    }

}
