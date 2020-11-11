package by.stankevich.artemiy.finalproject.dealerstat.controller;

import by.stankevich.artemiy.finalproject.dealerstat.entity.Status;
import by.stankevich.artemiy.finalproject.dealerstat.entity.User;
import by.stankevich.artemiy.finalproject.dealerstat.repository.UserRepository;
import by.stankevich.artemiy.finalproject.dealerstat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> findAll() {
        final List<User> list = userService.findAll();
        return list != null && !list.isEmpty()
                ? new ResponseEntity<>(list, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/users")
    public ResponseEntity<User> register(@Valid @RequestBody User user) {
        userService.register(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> findUserById(@PathVariable(value = "userId") UUID id) {
        User user = userService.findUserById(id);
        return id != null
                ? new ResponseEntity<>(user, HttpStatus.FOUND)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> approveUser(@PathVariable UUID id) {
        User user = userService.approveUser(id);
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<User> rejectedUser(@PathVariable UUID id) {
        User user = userService.rejectedUser(id);
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<?> deleteUserByIdIfRejected(@PathVariable(value = "userId") UUID id) {
        User user = userService.findUserById(id);
        if (user.getStatus().equals(Status.REJECTED)) {
            userService.deleteUserById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

}
