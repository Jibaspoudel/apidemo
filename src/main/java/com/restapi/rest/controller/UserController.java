package com.restapi.rest.controller;

import com.restapi.rest.entity.User;
import com.restapi.rest.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    // READ ALL users
    @GetMapping
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    // CREATE a user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return repo.save(user);
    }

    // READ one user by id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));
    }

    // UPDATE user by id
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id,
                           @RequestBody User user) {

        User existing = repo.findById(id).orElse(null);

        if (existing == null) {
            return null;   // user not found
        }

        existing.setName(user.getName());
        existing.setEmail(user.getEmail());

        return repo.save(existing);
    }

    // DELETE user by id
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        repo.deleteById(id);
        return "Deleted user with id = " + id;
    }
}
