package com.civilink.main_management_api.repository;

import com.civilink.main_management_api.entity.Tender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenderRepository extends JpaRepository<Tender, String> {
    // Custom query methods can go here if needed
}