package com.example.cg.service;

import com.example.cg.model.User;
import com.example.cg.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    private EmailService mailSender;

    @Override
    public User addUser(User user) {
        User user1 = userRepo.save(user);
        //mailSender.sendSimpleMessage(user.getEmail(), "hello", "testing");
        return user1;
    }

    @Override
    public User updateUser(Integer userId, User user) {
        User use = userRepo.findById(userId).orElse(new User());
        if (use.getId() != null)
            return userRepo.save(user);
        mailSender.sendSimpleMessage(user.getEmail(), "hello", "testing");
        return use;
    }


    @Override
    public void deleteUserById(Integer userId) {
        userRepo.deleteById(userId);
    }

    @Override
    public User getUserById(Integer userId) {
        return userRepo.findById(userId).orElse(new User());
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }
}
