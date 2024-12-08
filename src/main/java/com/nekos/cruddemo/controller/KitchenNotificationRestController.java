package com.nekos.cruddemo.controller;

import com.nekos.cruddemo.entity.KitchenNotification;
import com.nekos.cruddemo.service.KitchenNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class KitchenNotificationRestController {

    @Autowired
    private KitchenNotificationService kitchenNotificationService;

    @GetMapping("/notifications")
    public List<KitchenNotification> findAll(){
        return kitchenNotificationService.findAll();
    }

    @GetMapping("/notifications/{id}")
    public KitchenNotification findById(@PathVariable int id){
        return kitchenNotificationService.findById(id);
    }

    @PostMapping("/notifications")
    public KitchenNotification save(@RequestBody KitchenNotification kitchenNotification){
        return kitchenNotificationService.save(kitchenNotification);
    }

}
