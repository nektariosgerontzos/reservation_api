package com.nekos.cruddemo.service.Impl;

import com.nekos.cruddemo.entity.CafeTables;
import com.nekos.cruddemo.repository.CafeTablesRepository;
import com.nekos.cruddemo.service.CafeTablesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CafeTablesServiceImpl implements CafeTablesService {

    private final CafeTablesRepository cafeTablesRepository;

    public CafeTablesServiceImpl(CafeTablesRepository cafeTablesRepository) {
        this.cafeTablesRepository = cafeTablesRepository;
    }


    @Override
    public List<CafeTables> findAll() {
        return cafeTablesRepository.findAll();
    }

    @Override
    public CafeTables findById(int id) {
        return cafeTablesRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Cafe Table not found"));
    }

    @Override
    public CafeTables save(CafeTables cafeTables) {
        return cafeTablesRepository.save(cafeTables);
    }

    @Override
    public CafeTables updateUser(int id, CafeTables cafeTables) {
        return cafeTablesRepository.findById(id)
                .map(existingTable -> {
                    existingTable.setCapacity(cafeTables.getCapacity());
                    existingTable.setCreated_at(cafeTables.getCreated_at());
                    existingTable.setNumber(cafeTables.getNumber());
                    existingTable.setStatus(cafeTables.getStatus());
                    return cafeTablesRepository.save(existingTable);
                })
                .orElseThrow(()-> new RuntimeException("Not found Table"));
    }

    @Override
    public void deleteById(int id) {
        cafeTablesRepository.deleteById(id);
    }
}
