package com.nekos.cruddemo.controller;

import com.nekos.cruddemo.entity.CafeTables;
import com.nekos.cruddemo.service.CafeTablesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CafeTablesRestController {

    private final CafeTablesService cafeTablesService;

    public CafeTablesRestController(CafeTablesService cafeTablesService) {
        this.cafeTablesService = cafeTablesService;
    }

    @GetMapping("/cafetables")
    public List<CafeTables> findAll(){
        return cafeTablesService.findAll();
    }

    @PostMapping("/cafetables")
    public CafeTables save(@RequestBody CafeTables cafeTables){
        return cafeTablesService.save(cafeTables);
    }

}
