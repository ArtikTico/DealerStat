package by.stankevich.artemiy.finalproject.dealerstat.service;

import by.stankevich.artemiy.finalproject.dealerstat.entity.User;
import java.util.List;
import java.util.UUID;


public interface UserService {

    List<User> findAll();

    User findUserById (UUID id);

    User register(User user);

    void deleteUserById(UUID id);

    User approveUser(UUID id);

}
