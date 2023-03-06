package com.example.demo.controller;

import com.example.demo.model.RandomMatch;
import com.example.demo.service.RandomService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@CrossOrigin("http://localhost:4200")
@RestController
public class RandomController {

    @RequestMapping("/getMatch")
    public @ResponseBody
    List<RandomMatch> getResponse() throws IOException {
        return RandomService.getAll();
    }
}
