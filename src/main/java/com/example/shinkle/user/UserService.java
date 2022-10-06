package com.example.shinkle.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@Slf4j
public class UserService {
    //@Autowired
    UserRepository userRepository;
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
    public User createUser(User user) {
        if (userRepository.existsById(user.getId()))
            throw new RuntimeException("User already exists!");
        return userRepository.save(user);
    }
}
