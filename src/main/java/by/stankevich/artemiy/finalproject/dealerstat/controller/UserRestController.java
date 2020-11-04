package by.stankevich.artemiy.finalproject.dealerstat.controller;

import by.stankevich.artemiy.finalproject.dealerstat.entity.User;
import by.stankevich.artemiy.finalproject.dealerstat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private final UserService userService;
    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public User register(@RequestBody User user) {
        return userService.register(user);
    }
}
