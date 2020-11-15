package by.stankevich.artemiy.finalproject.dealerstat.controller;

import by.stankevich.artemiy.finalproject.dealerstat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/activate")
public class ActivationRestController {

    private final UserService userService;

    @Autowired
    public ActivationRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{code}")
    public ResponseEntity<String> activate(@PathVariable(value = "code") String code) {
        boolean isActivated = userService.activateUser(code);
        if (isActivated) {
            return new ResponseEntity<>("User successfully activate!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User has not been activate", HttpStatus.BAD_REQUEST);
        }
    }
}
