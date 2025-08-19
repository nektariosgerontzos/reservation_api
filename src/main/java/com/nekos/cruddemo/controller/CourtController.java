package com.nekos.cruddemo.controller;

import com.nekos.cruddemo.entity.Court;
import com.nekos.cruddemo.service.Impl.CourtService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourtController {

    private final CourtService courtService;

    public CourtController(CourtService courtService) {
        this.courtService = courtService;
    }

    @GetMapping("/courts")
    public List<Court> findAll(){
        return courtService.findAll();
    }

    @PostMapping("/courts")
    public Court save(@RequestBody Court court){
        return courtService.save(court);
    }

}
