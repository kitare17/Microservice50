package com.example.demo.service.imp;

import com.example.demo.entity.User;
import com.example.demo.respository.UserRepository;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user, Long id) {
        User existUser = userRepository.findById(id).orElse(null);
        if (user != null) {
            existUser.setEmail(user.getEmail());
            existUser.setFirstName(user.getFirstName());
            existUser.setLastName(user.getLastName());
            userRepository.save(existUser);
            return existUser;
        }
        else return null;
    }

}
