package com.example.backend.repository;

import com.example.backend.entities.CreditPersonnel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditPersonnelRepository extends JpaRepository<CreditPersonnel, Long> {
}