package by.stankevich.artemiy.finalproject.dealerstat.controller;

import by.stankevich.artemiy.finalproject.dealerstat.entity.User;
import by.stankevich.artemiy.finalproject.dealerstat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/userManagment")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.save(user);
    }
}
