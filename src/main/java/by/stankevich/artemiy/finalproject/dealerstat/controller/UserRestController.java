package by.stankevich.artemiy.finalproject.dealerstat.controller;

import by.stankevich.artemiy.finalproject.dealerstat.dto.UserDTO;
import by.stankevich.artemiy.finalproject.dealerstat.entity.User;
import by.stankevich.artemiy.finalproject.dealerstat.repository.UserRepository;
import by.stankevich.artemiy.finalproject.dealerstat.service.UserService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private final UserService userService;
    private final Mapper mapper;

    @Autowired
    public UserRestController(UserService userService, UserRepository userRepository, Mapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> findAll() {
        final List<User> list = userService.findAll();

        final List<UserDTO> listUserDTO = list.stream()
                .map(user -> mapper.map(user, UserDTO.class))
                .collect(Collectors.toList());

        return !listUserDTO.isEmpty()
                ? new ResponseEntity<>(listUserDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable(value = "userId") UUID id) {
        User user = userService.findUserById(id);
        return id != null
                ? new ResponseEntity<>(mapper.map(user, UserDTO.class), HttpStatus.FOUND)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
