package com.example.backend.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditProfessionnelDTO extends CreditDTO {
    private String motif;
    private String raisonSociale;
}