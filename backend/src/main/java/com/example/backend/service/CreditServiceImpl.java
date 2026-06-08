package com.example.backend.service;

import com.example.backend.dto.*;
import com.example.backend.entities.*;
import com.example.backend.enums.StatutCredit;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.mapper.CreditMapperImpl;
import com.example.backend.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreditServiceImpl implements CreditService {

    private final ClientRepository clientRepository;
    private final CreditRepository creditRepository;
    private final RemboursementRepository remboursementRepository;
    private final CreditMapperImpl mapper;

    @Override
    public ClientDTO createClient(ClientDTO dto) {
        Client client = mapper.fromClientDTO(dto);
        return mapper.fromClient(clientRepository.save(client));
    }

    @Override
    public CreditDTO addCreditPersonnel(CreditPersonnelDTO dto) {

        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new ResourceNotFoundException("Client introuvable"));

        CreditPersonnel credit = mapper.fromCreditPersonnelDTO(dto, client);

        credit.setDateDemande(new Date());
        credit.setStatut(StatutCredit.EN_COURS);

        return mapper.fromCreditPersonnel(creditRepository.save(credit));
    }

    @Override
    public CreditDTO addCreditImmobilier(CreditImmobilierDTO dto) {

        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new ResourceNotFoundException("Client introuvable"));

        CreditImmobilier credit = mapper.fromCreditImmobilierDTO(dto, client);

        credit.setDateDemande(new Date());
        credit.setStatut(StatutCredit.EN_COURS);

        return mapper.fromCreditImmobilier(creditRepository.save(credit));
    }

    // 🔥 NOUVEAU : CREDIT PROFESSIONNEL
    @Override
    public CreditDTO addCreditProfessionnel(CreditProfessionnelDTO dto) {

        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new ResourceNotFoundException("Client introuvable"));

        CreditProfessionnel credit = mapper.fromCreditProfessionnelDTO(dto, client);

        credit.setDateDemande(new Date());
        credit.setStatut(StatutCredit.EN_COURS);

        return mapper.fromCreditProfessionnel(creditRepository.save(credit));
    }

    @Override
    public RemboursementDTO addRemboursement(RemboursementDTO dto) {

        Credit credit = creditRepository.findById(dto.getCreditId())
                .orElseThrow(() -> new ResourceNotFoundException("Credit introuvable"));

        Remboursement r = new Remboursement();
        r.setDate(dto.getDate());
        r.setMontant(dto.getMontant());
        r.setType(dto.getType());
        r.setCredit(credit);

        return mapper.fromRemboursement(remboursementRepository.save(r));
    }

    @Override
    public List<CreditDTO> getCreditsByClient(Long clientId) {
        return creditRepository.findByClientId(clientId)
                .stream()
                .map(mapper::fromCredit)
                .collect(Collectors.toList());
    }
}