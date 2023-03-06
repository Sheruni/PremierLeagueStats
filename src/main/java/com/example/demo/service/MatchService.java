package com.example.demo.service;

import com.example.demo.model.Match;
import com.example.demo.repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class MatchService {

    public static List<Match> getAll() throws IOException {
        return MatchRepository.findAll();
    }

}
