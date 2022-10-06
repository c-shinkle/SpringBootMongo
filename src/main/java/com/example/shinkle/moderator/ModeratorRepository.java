package com.example.shinkle.moderator;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeratorRepository extends MongoRepository<Moderator, String> {
}
