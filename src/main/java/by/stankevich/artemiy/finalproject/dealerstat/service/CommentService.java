package by.stankevich.artemiy.finalproject.dealerstat.service;

import by.stankevich.artemiy.finalproject.dealerstat.entity.Comment;
import by.stankevich.artemiy.finalproject.dealerstat.entity.User;

import java.util.List;
import java.util.UUID;

public interface CommentService {
    //POST
    public Comment addingCommentsUser(Comment comment, UUID id);
    //GET LIST
    public List<Comment> getUserCommentsList(User user);
    //GET by ID
    public Comment getUserCommentById(User user , UUID id);
    //DELETE by ID
    public void deleteCommentUserById(User user, UUID id);
    //PUT by ID
    public Comment updateCommentById(UUID id);
}
