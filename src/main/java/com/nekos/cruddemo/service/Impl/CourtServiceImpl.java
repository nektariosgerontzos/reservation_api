package com.nekos.cruddemo.service.Impl;

import com.nekos.cruddemo.entity.Court;
import com.nekos.cruddemo.repository.CourtRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourtServiceImpl implements CourtService{

    private final CourtRepository courtRepository;

    public CourtServiceImpl(CourtRepository courtRepository) {
        this.courtRepository = courtRepository;
    }

    @Override
    public List<Court> findAll() {
        return courtRepository.findAll();
    }

    @Override
    public Court findById(Integer id) {
        return courtRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Court has not been found."));
    }

    @Override
    public Court save(Court court) {
        return courtRepository.save(court);
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Court updateCourt(Integer id, Court court) {
        return null;
    }
}
