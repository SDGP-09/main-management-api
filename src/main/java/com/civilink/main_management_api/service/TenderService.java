package com.civilink.main_management_api.service;


import com.civilink.main_management_api.entity.Tender;
import com.civilink.main_management_api.repository.TenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TenderService {
    @Autowired
    private TenderRepository tenderRepository;


    public Tender addTender(Tender tender) {
        return tenderRepository.save(tender);
    }

    public List<Tender> getAllTenders() {
        return tenderRepository.findAll();
    }

    public Optional<Tender> getTenderById(String id) {
        return tenderRepository.findById(id);
    }

    public Tender updateTender(String id, Tender updatedTender) {
        // Check if task exists
        Optional<Tender> existingTender = tenderRepository.findById(id);
        if (existingTender.isPresent()) {
            updatedTender.setId(id);
            return tenderRepository.save(updatedTender);
        }
        return null;
    }

    public boolean deleteTender(String id) {
        if (tenderRepository.existsById(id)) {
            tenderRepository.deleteById(id);
            return true;
        }
        return false;
    }




    // Method to create an empty task with default values
    public Tender createEmptyTask() {
        Tender tender = new Tender();
        return tenderRepository.save(tender);
    }


}
