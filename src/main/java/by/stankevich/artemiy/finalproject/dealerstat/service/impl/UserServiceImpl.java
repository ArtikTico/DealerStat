package by.stankevich.artemiy.finalproject.dealerstat.service.impl;

import by.stankevich.artemiy.finalproject.dealerstat.entity.Status;
import by.stankevich.artemiy.finalproject.dealerstat.entity.User;
import by.stankevich.artemiy.finalproject.dealerstat.entity.UserRole;
import by.stankevich.artemiy.finalproject.dealerstat.repository.UserRepository;
import by.stankevich.artemiy.finalproject.dealerstat.security.SecurityConfiguration;
import by.stankevich.artemiy.finalproject.dealerstat.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final SecurityConfiguration securityConfiguration;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, SecurityConfiguration securityConfiguration) {
        this.userRepository = userRepository;
        this.securityConfiguration = securityConfiguration;
    }

    @Override
    public List<User> findAll() {
        List<User> result = userRepository.findAll();
        log.info("IN findAll - users found, " + result.size());
        return result;
    }

    @Override
    public User findUserByById(UUID id) {
        User result = userRepository.findById(id).orElse(null);
        if (result == null) {
            log.warn("User has not found");
        }
        log.info("IN findUserById has found user:  " + result);
        return result;
    }

    @Override
    public User register(User user) {
        user.setPassword(securityConfiguration.passwordEncoder().encode(user.getPassword()));
        user.setRole(UserRole.TRADER);
        user.setStatus(Status.REQUESTED);
        user.setCreatedAt(new GregorianCalendar().getTime());
        User registeredUser = userRepository.save(user);
        log.info("IN register - user has successfully " + registeredUser);
        return registeredUser;
    }

    @Override
    public void deleteById(UUID id) {
        if (id == null) {
            log.warn("Id has not found!");
        } else {
            userRepository.deleteById(id);
            log.info("IN deleteById - delete has been successfully");
        }
    }
}
