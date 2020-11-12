package by.stankevich.artemiy.finalproject.dealerstat.service.impl;

import by.stankevich.artemiy.finalproject.dealerstat.entity.Comment;
import by.stankevich.artemiy.finalproject.dealerstat.entity.User;
import by.stankevich.artemiy.finalproject.dealerstat.repository.CommentRepository;
import by.stankevich.artemiy.finalproject.dealerstat.repository.UserRepository;
import by.stankevich.artemiy.finalproject.dealerstat.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Comment addingCommentsUser(Comment comment, UUID userId) {
        User user = userRepository.getOne(userId);
        comment.setApproved(false);
        comment.setUser(user);
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getUserCommentsList(UUID id) {
        List<Comment> result = commentRepository.findAllByUserId(id);
        log.info("IN getUserCommentsList - comment found , " + result);
        return result;
    }

    @Override
    public Comment findCommentByIdAndUser(UUID id, User user) {
        return commentRepository.findCommentByIdAndUser(id,user);
    }

}
