package com.example.backend.controller;

import com.example.backend.dto.*;
import com.example.backend.service.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/credits")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CreditController {

    private final CreditService creditService;

    @PostMapping("/personnel")
    public CreditDTO addPersonnel(@RequestBody CreditPersonnelDTO dto) {
        return creditService.addCreditPersonnel(dto);
    }

    @PostMapping("/immobilier")
    public CreditDTO addImmobilier(@RequestBody CreditImmobilierDTO dto) {
        return creditService.addCreditImmobilier(dto);
    }

    @PostMapping("/remboursement")
    public RemboursementDTO addRemboursement(@RequestBody RemboursementDTO dto) {
        return creditService.addRemboursement(dto);
    }

    @GetMapping("/client/{id}")
    public List<CreditDTO> getByClient(@PathVariable Long id) {
        return creditService.getCreditsByClient(id);
    }
}