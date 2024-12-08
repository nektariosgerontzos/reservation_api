package com.nekos.cruddemo.service.Impl;

import com.nekos.cruddemo.entity.KitchenNotification;
import com.nekos.cruddemo.repository.KitchenNotificationRepository;
import com.nekos.cruddemo.service.KitchenNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KitchenNotificationServiceImpl implements KitchenNotificationService {

    @Autowired
    private KitchenNotificationRepository kitchenNotificationRepository;

    @Override
    public List<KitchenNotification> findAll() {
        return kitchenNotificationRepository.findAll();
    }

    @Override
    public KitchenNotification findById(int id) {
        return kitchenNotificationRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Notification not found"));
    }

    @Override
    public KitchenNotification save(KitchenNotification kitchenNotification) {
        return kitchenNotificationRepository.save(kitchenNotification);
    }

    @Override
    public void delete(int id) {
        kitchenNotificationRepository.deleteById(id);
    }

    @Override
    public KitchenNotification update(int id, KitchenNotification kitchenNotification) {
        return kitchenNotificationRepository.findById(id)
                .map(notification -> {
                    notification.setOrder(kitchenNotification.getOrder());
                    notification.setStatus(kitchenNotification.getStatus());
                    notification.setSentAt(kitchenNotification.getSentAt());
                    notification.setNoticedAt(kitchenNotification.getNoticedAt());
                    return kitchenNotificationRepository.save(notification);
                })
                .orElseThrow(()-> new IllegalArgumentException("Notification not found."));
    }
}
