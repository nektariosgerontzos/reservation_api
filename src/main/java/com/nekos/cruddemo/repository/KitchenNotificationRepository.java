package com.nekos.cruddemo.repository;

import com.nekos.cruddemo.entity.KitchenNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KitchenNotificationRepository extends JpaRepository<KitchenNotification, Integer> {

    //methods

}
