package com.example.shinkle.moderator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ModeratorController {
  ModeratorService moderatorService;
  public ModeratorController(ModeratorService moderatorService) {
    this.moderatorService = moderatorService;
  }
  @GetMapping("/moderators")
  public List<Moderator> list() {
    log.info("Finding all moderators!");
    return moderatorService.findAllModerators();
  }

  @PostMapping("/moderators")
  public ResponseEntity<String> saveModerator(@RequestBody Moderator moderator) {
    try {
      log.info("Saving user: {}", moderator);
      Moderator savedModerator = moderatorService.createModerator(moderator);
      return ResponseEntity.status(HttpStatus.CREATED).header("id", String.valueOf(savedModerator.getId())).build();
    }
    catch(RuntimeException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }
}
