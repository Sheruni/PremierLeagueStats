package com.example.demo.service;

import com.example.demo.model.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class RandomService {

    public static List<RandomMatch> getAll() throws IOException {

        List<RandomMatch> list = Arrays.asList(
                RandomMatch.generateMatch()
        );
        PremierLeagueManager.saveClubs();
        PremierLeagueManager.saveMatches();

        return list;

    }

}
