package by.stankevich.artemiy.finalproject.dealerstat.service.impl;

import by.stankevich.artemiy.finalproject.dealerstat.entity.Comment;
import by.stankevich.artemiy.finalproject.dealerstat.entity.User;
import by.stankevich.artemiy.finalproject.dealerstat.repository.CommentRepository;
import by.stankevich.artemiy.finalproject.dealerstat.repository.UserRepository;
import by.stankevich.artemiy.finalproject.dealerstat.service.CommentService;
import by.stankevich.artemiy.finalproject.dealerstat.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserService userService;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, UserService userService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
    }

    @Override
    public void addingCommentsUser(Comment comment, UUID id) {
        User user = userService.findUserById(id);
        if (user != null && comment != null) {
            comment.setUser(user);
            comment.setApproved(false);
            log.info("IN addingCommentUser - comment for this user has been successfully adding");
            commentRepository.save(comment);
//            Set<Comment> commentStream = Stream.of(comment).collect(Collectors.toSet());
//  TODO: fix user.setComment(commentStream);
            log.info("IN addingCommentsUser - commit was been successfully create " + comment);
        } else {
            log.warn("Not Found user with id = " + id);
        }
    }

    @Override
    public List<Comment> getUserCommentsList(User user) {
        List<Comment> result = commentRepository.findAllById(Collections.singleton(user.getId()));
        log.info("IN getUserCommentsList - comment found , " + result.size());
        return result;
    }

    @Override
    public Comment getUserCommentById(User user, UUID id) {
        return null;
    }

    @Override
    public void deleteCommentUserById(User user, UUID id) {

    }

    @Override
    public Comment updateCommentById(UUID id) {
        return null;
    }
}
