package by.stankevich.artemiy.finalproject.dealerstat.service.impl;

import by.stankevich.artemiy.finalproject.dealerstat.entity.Comment;
import by.stankevich.artemiy.finalproject.dealerstat.entity.User;
import by.stankevich.artemiy.finalproject.dealerstat.repository.CommentRepository;
import by.stankevich.artemiy.finalproject.dealerstat.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment addingCommentsUser(Comment comment, UUID id) {
        return null;
    }

    @Override
    public List<Comment> getUserCommentsList(User user) {
        return null;
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
