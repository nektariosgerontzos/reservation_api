package com.nekos.cruddemo.service;

import com.nekos.cruddemo.entity.KitchenNotification;

import java.util.List;

public interface KitchenNotificationService {

    List<KitchenNotification> findAll();
    KitchenNotification findById(int id);
    KitchenNotification save(KitchenNotification kitchenNotification);
    void delete(int id);
    KitchenNotification update(int id, KitchenNotification kitchenNotification);

}
