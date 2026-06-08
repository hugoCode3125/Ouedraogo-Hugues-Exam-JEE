package com.example.backend.dto;

import com.example.backend.enums.TypeRemboursement;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RemboursementDTO {
    private Long id;
    private Date date;
    private double montant;
    private TypeRemboursement type;
    private Long creditId;
}