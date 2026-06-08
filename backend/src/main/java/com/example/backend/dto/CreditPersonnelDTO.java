package com.example.backend.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditPersonnelDTO extends CreditDTO {
    private String motif;
}