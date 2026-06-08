package com.example.backend.controller;

import com.example.backend.dto.ClientDTO;
import com.example.backend.service.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ClientController {

    private final CreditService creditService;

    @PostMapping
    public ClientDTO create(@RequestBody ClientDTO dto) {
        return creditService.createClient(dto);
    }
}