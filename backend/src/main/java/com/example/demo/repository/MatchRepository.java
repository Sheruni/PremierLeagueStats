package com.example.demo.repository;

import com.example.demo.model.Match;
import com.example.demo.model.PremierLeagueManager;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MatchRepository {

    public static List<Match> findAll() throws IOException {
        PremierLeagueManager.retrieveMatches();
        return  PremierLeagueManager.matchList;
    }
}

