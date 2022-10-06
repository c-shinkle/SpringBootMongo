package com.example.shinkle.moderator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ModeratorService {
    //@Autowired
    private ModeratorRepository moderatorRepository;
    public ModeratorService(ModeratorRepository moderatorRepository)
    {
        this.moderatorRepository = moderatorRepository;
    }
    public List<Moderator> findAllModerators() {
        return moderatorRepository.findAll();
    }
    public Moderator createModerator(Moderator moderator) {
        if (moderatorRepository.existsById(moderator.getId()))
            throw new RuntimeException("Moderator already exists!");
        return moderatorRepository.save(moderator);
    }
}
