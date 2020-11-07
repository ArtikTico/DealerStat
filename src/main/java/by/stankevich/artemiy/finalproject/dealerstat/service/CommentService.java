package by.stankevich.artemiy.finalproject.dealerstat.service;

import by.stankevich.artemiy.finalproject.dealerstat.entity.Comment;
import by.stankevich.artemiy.finalproject.dealerstat.entity.User;

import java.util.List;
import java.util.UUID;

public interface CommentService {

    void addingCommentsUser(Comment comment, UUID id);

    List<Comment> getUserCommentsList(UUID id);

    Comment getUserCommentById(User user , UUID id);

    void deleteCommentUserById(User user, UUID id);

    Comment updateCommentById(UUID id);
}
