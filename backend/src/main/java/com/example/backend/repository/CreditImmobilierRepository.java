package com.example.backend.repository;

import com.example.backend.entities.CreditImmobilier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditImmobilierRepository extends JpaRepository<CreditImmobilier, Long> {
}