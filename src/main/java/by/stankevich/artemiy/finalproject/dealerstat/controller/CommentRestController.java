package by.stankevich.artemiy.finalproject.dealerstat.controller;

import by.stankevich.artemiy.finalproject.dealerstat.entity.Comment;
import by.stankevich.artemiy.finalproject.dealerstat.entity.User;
import by.stankevich.artemiy.finalproject.dealerstat.service.CommentService;
import by.stankevich.artemiy.finalproject.dealerstat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class CommentRestController {

    private final CommentService commentService;
    private final UserService userService;

    @Autowired
    public CommentRestController(CommentService commentService, UserService userService) {
        this.commentService = commentService;
        this.userService = userService;
    }

    @PostMapping("/{userId}/comments")
    public ResponseEntity<?> createCommentForUserById(@Valid @RequestBody Comment comment,
                                                      @PathVariable(value = "userId") UUID id) {
        if (comment != null && id != null) {
            commentService.addingCommentsUser(comment, id);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{userId}/comments")
    public ResponseEntity<List<Comment>> findAllCommentsByUserId(@PathVariable (value = "userId") UUID id) {
        return new ResponseEntity<>(commentService.getUserCommentsList(id), HttpStatus.OK);
    }
}
