package com.example.demo.repository;

import com.example.demo.model.FootballClub;
import com.example.demo.model.PremierLeagueManager;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClubRepository{

    public static List<FootballClub> findAll() throws IOException {
        PremierLeagueManager.retrieveClubs();
        return PremierLeagueManager.leagueList;
    }
}
