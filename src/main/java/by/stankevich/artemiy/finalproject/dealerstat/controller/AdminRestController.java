package by.stankevich.artemiy.finalproject.dealerstat.controller;

import by.stankevich.artemiy.finalproject.dealerstat.entity.Comment;
import by.stankevich.artemiy.finalproject.dealerstat.entity.User;
import by.stankevich.artemiy.finalproject.dealerstat.service.CommentService;
import by.stankevich.artemiy.finalproject.dealerstat.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@RestController
@RequestMapping("/api/admin")
public class AdminRestController {

    private final UserService userService;
    private final CommentService commentService;

    public AdminRestController(UserService userService, CommentService commentService) {
        this.userService = userService;
        this.commentService = commentService;
    }

    @PutMapping("/users/approved/{id}")
    public ResponseEntity<User> approveUser(@PathVariable UUID id) {
        User user = userService.approveUser(id);
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/users/rejected/{id}")
    public ResponseEntity<User> rejectedUser(@PathVariable UUID id) {
        User user = userService.rejectedUser(id);
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/comments/approvedComment/{id}")
    public ResponseEntity<Comment> approveComment(@PathVariable UUID id) {
        Comment comment = commentService.approveCommentById(id);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @PutMapping("/comments/rejectedComment/{id}")
    public ResponseEntity<Comment> rejectComment(@PathVariable UUID id) {
        Comment comment = commentService.rejectCommentById(id);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

}
