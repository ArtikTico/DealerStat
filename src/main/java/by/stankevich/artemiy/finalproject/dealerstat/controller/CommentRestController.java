package by.stankevich.artemiy.finalproject.dealerstat.controller;

import by.stankevich.artemiy.finalproject.dealerstat.entity.Comment;
import by.stankevich.artemiy.finalproject.dealerstat.entity.User;
import by.stankevich.artemiy.finalproject.dealerstat.service.CommentService;
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

    @Autowired
    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/{userId}/comments")
    public ResponseEntity<?> createCommentForUser(@Valid @RequestBody Comment comment,
                                                  @PathVariable (value = "userId") UUID id) {
        if (comment != null) {
            commentService.addingCommentsUser(comment,id);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{userId}/comments")
    public ResponseEntity<List<Comment>> findAllCommentsByUserId(@PathVariable(value = "userId") UUID id) {
        return new ResponseEntity<>(commentService.getUserCommentsList(id), HttpStatus.OK);
    }

    @GetMapping("/{userId}/comments/{commentId}")
    public ResponseEntity<Comment> getCommentById(@PathVariable(value = "commentId") UUID commentId,
                                                  @PathVariable(value = "userId") User user) {
        Comment comment = commentService.findCommentByIdAndUser(commentId, user);
        if (comment != null) {
            return new ResponseEntity<>(comment, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
