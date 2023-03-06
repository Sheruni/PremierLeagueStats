package com.example.demo.controller;

import com.example.demo.model.FootballClub;
import com.example.demo.service.FootballClubService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
public class ClubController {


    @GetMapping("/getClubs")
    public @ResponseBody List<FootballClub> getResponse() throws IOException {
        return FootballClubService.getAll();
    }
}
