package by.stankevich.artemiy.finalproject.dealerstat.repository;

import by.stankevich.artemiy.finalproject.dealerstat.entity.Comment;
import by.stankevich.artemiy.finalproject.dealerstat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Repository
public interface CommentRepository extends JpaRepository<Comment, UUID> {

    @Transactional(readOnly = true)
    List<Comment> findAllByUserId(UUID id);

    @Query(nativeQuery = true, value = "SELECT * FROM comment c WHERE c.id = ?1 and c.user_id = ?2")
    @Transactional(readOnly = true)
    Comment findCommentByIdAndUser(UUID commentId, User user);

}
