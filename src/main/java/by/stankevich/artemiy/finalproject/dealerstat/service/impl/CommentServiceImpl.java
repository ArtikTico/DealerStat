package by.stankevich.artemiy.finalproject.dealerstat.service.impl;

import by.stankevich.artemiy.finalproject.dealerstat.entity.Comment;
import by.stankevich.artemiy.finalproject.dealerstat.entity.Status;
import by.stankevich.artemiy.finalproject.dealerstat.entity.User;
import by.stankevich.artemiy.finalproject.dealerstat.repository.CommentRepository;
import by.stankevich.artemiy.finalproject.dealerstat.service.CommentService;
import by.stankevich.artemiy.finalproject.dealerstat.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

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
        if (user != null && comment != null && user.getStatus().equals(Status.APPROVED)) {
            comment.setUser(user);
            comment.setApproved(false);
            log.info("IN addingCommentUser - comment for this user has been successfully adding");
            commentRepository.save(comment);
        } else {
            log.warn("Not Found user with id = " + id);
        }
    }

    @Override
    public List<Comment> getUserCommentsList(UUID id) {
        List<Comment> result = commentRepository.findAllByUserId(id);
        log.info("IN getUserCommentsList - comment found , " + result);
        return result;
    }

    @Override
    public void deleteByComment(Comment comment) {
        commentRepository.delete(comment);
    }

    @Override
    public Comment findCommentByIdAndUser(UUID id, User user) {
        return commentRepository.findCommentByIdAndUser(id,user);
    }


    @Override
    public Comment updateCommentById(UUID id) {
        return null;
    }

}
