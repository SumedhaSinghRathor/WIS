package wis_backend.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import wis_backend.model.User;
import wis_backend.repo.UserRepo;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
    @Autowired
    UserRepo repo;

    @GetMapping("/users")
    public List<User> getAllUser() {
        return repo.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable ObjectId id) {
        return repo.findById(id).orElse(null);
    }
}
