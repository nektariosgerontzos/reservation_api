package com.nekos.cruddemo.service.Impl;

import com.nekos.cruddemo.entity.CourtAvailability;
import com.nekos.cruddemo.repository.CourtAvailabilityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourtAvailabilityServiceImpl implements CourtAvailabilityService{

    private final CourtAvailabilityRepository courtAvailabilityRepository;

    public CourtAvailabilityServiceImpl(CourtAvailabilityRepository courtAvailabilityRepository) {
        this.courtAvailabilityRepository = courtAvailabilityRepository;
    }

    @Override
    public List<CourtAvailability> findAll() {
        return courtAvailabilityRepository.findAll();
    }

    @Override
    public CourtAvailability findById(int id) {
        return courtAvailabilityRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Availability has not been found."));
    }

    @Override
    public CourtAvailability save(CourtAvailability courtAvailability) {
        return courtAvailabilityRepository.save(courtAvailability);
    }

    @Override
    public void deleteById(int id) {

    }
}
