package com.example.backend.entities;

import com.example.backend.enums.StatutCredit;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dateDemande;

    @Enumerated(EnumType.STRING)
    private StatutCredit statut;

    @Temporal(TemporalType.DATE)
    private Date dateAcceptation;

    private double montant;

    private int dureeRemboursement;

    private double tauxInteret;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "credit")
    private List<Remboursement> remboursements;

}