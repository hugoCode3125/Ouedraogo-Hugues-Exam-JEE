package com.example.backend.entities;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditProfessionnel extends Credit {

    private String motif;

    private String raisonSociale;

}