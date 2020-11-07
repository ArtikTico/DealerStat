package by.stankevich.artemiy.finalproject.dealerstat.service.impl;

import by.stankevich.artemiy.finalproject.dealerstat.entity.Status;
import by.stankevich.artemiy.finalproject.dealerstat.entity.User;
import by.stankevich.artemiy.finalproject.dealerstat.entity.UserRole;
import by.stankevich.artemiy.finalproject.dealerstat.exceptions.ResourceNotFoundException;
import by.stankevich.artemiy.finalproject.dealerstat.mail.MailService;
import by.stankevich.artemiy.finalproject.dealerstat.repository.UserRepository;
import by.stankevich.artemiy.finalproject.dealerstat.security.SecurityConfiguration;
import by.stankevich.artemiy.finalproject.dealerstat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final SecurityConfiguration securityConfiguration;
    private final MailService mailService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, SecurityConfiguration securityConfiguration, MailService mailService) {
        this.userRepository = userRepository;
        this.securityConfiguration = securityConfiguration;
        this.mailService = mailService;
    }

    @Override
    public List<User> findAll() {
        List<User> result = userRepository.findAll();
        if (result.isEmpty()) {
            throw new ResourceNotFoundException("list users not found");
        }
        return result;
    }

    @Override
    public User findUserById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User has not found"));
    }

    @Override
    public User register(User user) {
        user.setPassword(securityConfiguration.passwordEncoder().encode(user.getPassword()));
        user.setRole(UserRole.TRADER);
        user.setStatus(Status.REQUESTED);
        User registeredUser = userRepository.save(user);
//        mailService.sendEmailConfirmRegistration("artictico@gmail.com",user.getFirstName(), user.getLastName());
        return registeredUser;
    }

    @Override
    public User approveUser(UUID id) {
        return userRepository.findById(id).map(user -> {
            user.setStatus(Status.APPROVED);
            return userRepository.save(user);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found user by id: " + id));
    }

    @Override
    public void deleteUserById(UUID id) {
        userRepository.deleteById(id);
    }
}
