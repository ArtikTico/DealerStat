package by.stankevich.artemiy.finalproject.dealerstat.service;

import by.stankevich.artemiy.finalproject.dealerstat.entity.User;
import java.util.List;
import java.util.UUID;


public interface UserService {

    List<User> findAll();

    User findUserById (UUID id);

    User findUserByEmail(String email);

    User register(User user);

    User approveUser(UUID id);

    User rejectedUser(UUID id);

    boolean activateUser(String code);

}
