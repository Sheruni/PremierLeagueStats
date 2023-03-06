package com.example.demo.service;

import com.example.demo.model.FootballClub;
import com.example.demo.repository.ClubRepository;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

@Service
public class FootballClubService {

    public static List<FootballClub> getAll() throws IOException {
            return ClubRepository.findAll();
        }

}
