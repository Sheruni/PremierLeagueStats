package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.MatchService;
import com.example.demo.service.RandomService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:4200")
@RestController
public class MatchController {

    @GetMapping("/getMatches")
    public @ResponseBody List<Match> getResponse() throws IOException {
        return MatchService.getAll();
    }

}
