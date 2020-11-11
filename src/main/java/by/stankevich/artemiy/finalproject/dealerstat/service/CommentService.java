package by.stankevich.artemiy.finalproject.dealerstat.service;

import by.stankevich.artemiy.finalproject.dealerstat.entity.Comment;
import by.stankevich.artemiy.finalproject.dealerstat.entity.User;

import java.util.List;
import java.util.UUID;
public interface CommentService {

    void addingCommentsUser(Comment comment, UUID id);

    List<Comment> getUserCommentsList(UUID id);

    void deleteByComment(Comment comment);

    Comment findCommentByIdAndUser(UUID id, User user);

    Comment updateCommentById(UUID id);
}
