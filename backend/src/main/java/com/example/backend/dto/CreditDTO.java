package com.example.backend.dto;

import com.example.backend.enums.StatutCredit;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditDTO {

    private Long id;
    private Date dateDemande;
    private StatutCredit statut;
    private Date dateAcceptation;
    private double montant;
    private int dureeRemboursement;
    private double tauxInteret;

    private Long clientId;
}