package com.example.backend.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditImmobilierDTO extends CreditDTO {
    private String typeBien;
}