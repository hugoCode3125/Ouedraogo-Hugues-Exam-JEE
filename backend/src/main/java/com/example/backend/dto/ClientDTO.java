package com.example.backend.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDTO {
    private Long id;
    private String nom;
    private String email;
}