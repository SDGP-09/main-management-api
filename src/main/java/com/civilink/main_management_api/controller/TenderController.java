package com.civilink.main_management_api.controller;



import com.civilink.main_management_api.dto.TenderRequest;
import com.civilink.main_management_api.dto.TenderResponse;
import com.civilink.main_management_api.entity.Tender;
import com.civilink.main_management_api.service.TenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tenders")
public class TenderController {
    @Autowired
    private TenderService tenderService;

    // Create empty tender (for new tender form)
    @PostMapping("/create-empty")
    public ResponseEntity<TenderResponse> createEmptyTender() {
        Tender newTender = tenderService.createEmptyTender();
        return ResponseEntity.ok(new TenderResponse(newTender));
    }

    // Get all tenders for Gantt chart
    @GetMapping
    public ResponseEntity<List<TenderResponse>> getAllTenders() {
        List<Tender> tenders = tenderService.getAllTenders();
        List<TenderResponse> responses = tenders.stream()
                .map(TenderResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    // Get tender details by ID
    @GetMapping("/{id}")
    public ResponseEntity<TenderResponse> getTenderById(@PathVariable String id) {
        Optional<Tender> tender = tenderService.getTenderById(id);
        return tender.map(t -> ResponseEntity.ok(new TenderResponse(t)))
                .orElse(ResponseEntity.notFound().build());
    }

    // Save or update tender
    @PostMapping("/save")
    public ResponseEntity<TenderResponse> saveTender(@RequestBody TenderRequest tenderRequest) {
        Tender tender = convertToEntity(tenderRequest);
        Tender savedTender = tenderService.addTender(tender);
        return ResponseEntity.ok(new TenderResponse(savedTender));
    }

    // Update tender
    @PutMapping("/{id}")
    public ResponseEntity<TenderResponse> updateTender(@PathVariable String id, @RequestBody TenderRequest tenderRequest) {
        Tender tender = convertToEntity(tenderRequest);
        Tender updatedTender = tenderService.updateTender(id, tender);

        if (updatedTender != null) {
            return ResponseEntity.ok(new TenderResponse(updatedTender));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete task
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTender(@PathVariable String id) {
        boolean deleted = tenderService.deleteTender(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Helper method to convert DTO to entity
    private Tender convertToEntity(TenderRequest tenderRequest) {
        return new Tender(
                tenderRequest.getId(),
                tenderRequest.getName(),
                tenderRequest.getOpenDate(),
                tenderRequest.getCloseDate(),
                tenderRequest.getProgress(),
                tenderRequest.getDependencies(),
                tenderRequest.getDescription()
        );
    }

}
