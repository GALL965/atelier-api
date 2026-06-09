package atelier_api.controllers;

import atelier_api.models.User;
import atelier_api.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping("/register")
    public User register(
        @RequestBody User user
    ) {

        return repository.save(user);
    }

    @PostMapping("/login")
    public User login(
        @RequestBody User loginData
    ) {

        User user =
            repository.findByEmail(
                loginData.getEmail()
            );

        if (
            user != null &&
            user.getPassword().equals(
                loginData.getPassword()
            )
        ) {

            return user;
        }

        return null;
    }
}
