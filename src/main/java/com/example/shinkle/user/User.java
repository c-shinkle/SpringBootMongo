package com.example.shinkle.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@Data
public class User {
  @Id
  private int id;
  private String firstName;
  private String lastName;

}
