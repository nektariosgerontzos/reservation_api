package com.nekos.cruddemo.service.Impl;

import com.nekos.cruddemo.entity.Shift;
import com.nekos.cruddemo.repository.ShiftRepository;
import com.nekos.cruddemo.service.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftServiceImpl implements ShiftService {

    @Autowired
    private ShiftRepository shiftRepository;

    @Override
    public List<Shift> findAll() {
        return shiftRepository.findAll();
    }

    @Override
    public Shift findById(int id) {
        return shiftRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Not found"));
    }

    @Override
    public void deleteById(int id) {
        shiftRepository.deleteById(id);
    }

    @Override
    public Shift update(int id, Shift shift) {
        return shiftRepository.findById(id)
                .map(existing -> {
                    existing.setEnd_time(shift.getEnd_time());
                    existing.setStart_time(shift.getStart_time());
                    existing.setUser(shift.getUser());
                    existing.setStatus(shift.getStatus());
                    return shiftRepository.save(shift);
                })
                .orElseThrow(() -> new IllegalArgumentException("Not found"));
    }

    @Override
    public Shift save(Shift shift) {
        return shiftRepository.save(shift);
    }
}
