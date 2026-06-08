package com.example.backend.service;

import com.example.backend.dto.*;

import java.util.List;

public interface CreditService {

    ClientDTO createClient(ClientDTO dto);

    CreditDTO addCreditPersonnel(CreditPersonnelDTO dto);

    CreditDTO addCreditImmobilier(CreditImmobilierDTO dto);

    CreditDTO addCreditProfessionnel(CreditProfessionnelDTO dto);

    RemboursementDTO addRemboursement(RemboursementDTO dto);

    List<CreditDTO> getCreditsByClient(Long clientId);
}