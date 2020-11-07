package by.stankevich.artemiy.finalproject.dealerstat.service;

import by.stankevich.artemiy.finalproject.dealerstat.entity.User;
import java.util.List;
import java.util.UUID;


public interface UserService {

    public List<User> findAll();

    User findUserById (UUID id);

    public User register(User user);

    public void deleteById(UUID id);

    public void updateUser(UUID id);

}
