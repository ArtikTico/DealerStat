package by.stankevich.artemiy.finalproject.dealerstat.repository;

import by.stankevich.artemiy.finalproject.dealerstat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    User findUserByEmail(String email);

    User findByActivationCode(String code);
}
