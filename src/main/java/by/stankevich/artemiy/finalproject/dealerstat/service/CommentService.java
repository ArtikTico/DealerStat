package by.stankevich.artemiy.finalproject.dealerstat.service;

import by.stankevich.artemiy.finalproject.dealerstat.entity.Comment;
import by.stankevich.artemiy.finalproject.dealerstat.entity.User;

import java.util.List;
import java.util.UUID;
public interface CommentService {

    Comment addingCommentsUser(Comment comment, UUID userId);

    List<Comment> getUserCommentsList(UUID id);

    Comment findCommentByIdAndUser(UUID id, User user);
}
