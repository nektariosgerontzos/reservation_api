package com.nekos.cruddemo.service.Impl;

import com.nekos.cruddemo.entity.CourtAvailability;

import java.util.List;

public interface CourtAvailabilityService {

    List<CourtAvailability> findAll();

    CourtAvailability findById(int id);

    CourtAvailability save(CourtAvailability courtAvailability);

    void deleteById(int id);

}
