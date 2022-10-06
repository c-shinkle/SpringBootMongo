package com.example.shinkle.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Slf4j
public class UserController {
  UserService userService;
  public UserController(UserService userService) {
    this.userService = userService;
  }
  @GetMapping("/users")
  public List<User> list() {
    log.info("Finding all users!");
    return userService.findAllUsers();
  }

  @PostMapping("/users")
  public ResponseEntity<String> saveUser(@RequestBody User user) {
    try {
      log.info("Saving user: {}", user);
      User savedUser = userService.createUser(user);
      return ResponseEntity.status(HttpStatus.CREATED).header("id", String.valueOf(savedUser.getId())).build();
    }
    catch(RuntimeException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }
}
