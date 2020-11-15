package by.stankevich.artemiy.finalproject.dealerstat.controller;

import by.stankevich.artemiy.finalproject.dealerstat.dto.CommentDTO;
import by.stankevich.artemiy.finalproject.dealerstat.entity.Comment;
import by.stankevich.artemiy.finalproject.dealerstat.service.CommentService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class CommentRestController {

    private final CommentService commentService;
    private final Mapper mapper;

    @Autowired
    public CommentRestController(CommentService commentService, Mapper mapper) {
        this.commentService = commentService;
        this.mapper = mapper;
    }

    @PostMapping("/{userId}/comments")
    public ResponseEntity<CommentDTO> createCommentForUser(@Valid @RequestBody Comment comment,
                                                           @PathVariable (value = "userId") UUID id) {
        if (comment != null) {
            commentService.saveComment(comment,id);
            return new ResponseEntity<>(mapper.map(comment,CommentDTO.class),HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{userId}/comments")
    public ResponseEntity<List<CommentDTO>> findAllCommentsByUserId(@PathVariable(value = "userId") UUID id) {
        List<Comment> comments =  commentService.getUserCommentsList(id);
        List<CommentDTO> commentDTO = comments.stream()
                .map(comment -> mapper.map(comment, CommentDTO.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(commentDTO, HttpStatus.OK);
    }


}
