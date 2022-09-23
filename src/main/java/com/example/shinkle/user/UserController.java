package com.example.shinkle.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Slf4j
public class UserController {
  @Autowired
  UserRepository userRepository;

  @GetMapping("/users")
  public List<User> list() {
    log.info("Finding all users!");
    return userRepository.findAll();
  }

  @PostMapping("/users")
  public ResponseEntity<Void> saveUser(@RequestBody User user) {
    log.info("Saving user: {}", user);
    User savedUser = userRepository.save(user);

    return ResponseEntity.status(HttpStatus.CREATED).header("id", String.valueOf(savedUser.getId())).build();
  }
}
