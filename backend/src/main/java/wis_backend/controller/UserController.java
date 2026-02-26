package wis_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import wis_backend.model.User;
import wis_backend.repo.UserRepo;

@RestController
public class UserController {
    @Autowired
    UserRepo repo;

    @GetMapping("/users")
    public List<User> getAllUser() {
        return repo.findAll();
    }
}
