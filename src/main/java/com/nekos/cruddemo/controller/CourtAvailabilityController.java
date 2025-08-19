package com.nekos.cruddemo.controller;

import com.nekos.cruddemo.entity.CourtAvailability;
import com.nekos.cruddemo.service.Impl.CourtAvailabilityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourtAvailabilityController {

    private final CourtAvailabilityService courtAvailabilityService;

    public CourtAvailabilityController(CourtAvailabilityService courtAvailabilityService) {
        this.courtAvailabilityService = courtAvailabilityService;
    }

    @GetMapping("/availability")
    public List<CourtAvailability> findAll(){
        return courtAvailabilityService.findAll();
    }

    @PostMapping("/availability")
    public CourtAvailability save(@RequestBody CourtAvailability courtAvailability){
        return courtAvailabilityService.save(courtAvailability);
    }

}
