package by.stankevich.artemiy.finalproject.dealerstat.repository;

import by.stankevich.artemiy.finalproject.dealerstat.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CommentRepository extends JpaRepository<Comment, UUID> {
    List<Comment> findAllByUserId(UUID id);
}
