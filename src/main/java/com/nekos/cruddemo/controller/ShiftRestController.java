package com.nekos.cruddemo.controller;

import com.nekos.cruddemo.entity.Shift;
import com.nekos.cruddemo.service.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ShiftRestController {

    @Autowired
    private ShiftService shiftService;

    @GetMapping("/shifts")
    public List<Shift> findAll(){
        return shiftService.findAll();
    }

    @GetMapping("/shifts/{id}")
    public Shift findById(@PathVariable int id){
        return shiftService.findById(id);
    }

    @PostMapping("/shifts")
    public Shift save(@RequestBody Shift shift){
        return shiftService.save(shift);
    }

}
