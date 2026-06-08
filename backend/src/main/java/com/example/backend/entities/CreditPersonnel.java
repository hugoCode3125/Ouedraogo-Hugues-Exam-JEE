package com.example.backend.entities;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditPersonnel extends Credit {

    private String motif;

}