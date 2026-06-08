package com.example.backend.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CreditPersonnelDTO extends CreditDTO {
    private String motif;
}