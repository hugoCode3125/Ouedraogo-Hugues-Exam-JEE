package com.example.backend.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CreditImmobilierDTO extends CreditDTO {
    private String typeBien;
}