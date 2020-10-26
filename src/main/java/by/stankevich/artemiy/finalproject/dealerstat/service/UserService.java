package by.stankevich.artemiy.finalproject.dealerstat.service;

import by.stankevich.artemiy.finalproject.dealerstat.entity.User;
import by.stankevich.artemiy.finalproject.dealerstat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(User user) {
        return userRepository.getOne(user.getId());
    }

    public User save(User user) {
       return userRepository.save(user);
    }

    public void deleteById(User user) {
        userRepository.deleteById(user.getId());
    }

}
