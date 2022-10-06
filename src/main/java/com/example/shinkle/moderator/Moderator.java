package com.example.shinkle.moderator;

import lombok.*;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "moderator")
@Data
@Value
@AllArgsConstructor
public class Moderator {
  @Id
  private String id;
  private String userName;
  private LocalDate cakeDay;
  private int numberOfPosts;
}
