package com.example.backend.mapper;

import com.example.backend.dto.*;
import com.example.backend.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CreditMapperImpl {

    // ===================== CLIENT =====================
    public ClientDTO fromClient(Client client) {
        ClientDTO dto = new ClientDTO();
        BeanUtils.copyProperties(client, dto);
        return dto;
    }

    public Client fromClientDTO(ClientDTO dto) {
        Client client = new Client();
        BeanUtils.copyProperties(dto, client);
        return client;
    }

    // ===================== CREDIT BASE =====================
    public CreditDTO fromCredit(Credit credit) {
        CreditDTO dto = new CreditDTO();
        BeanUtils.copyProperties(credit, dto);

        if (credit.getClient() != null)
            dto.setClientId(credit.getClient().getId());

        return dto;
    }

    // ===================== CREDIT PERSONNEL =====================
    public CreditPersonnelDTO fromCreditPersonnel(CreditPersonnel credit) {
        CreditPersonnelDTO dto = new CreditPersonnelDTO();
        BeanUtils.copyProperties(credit, dto);

        if (credit.getClient() != null)
            dto.setClientId(credit.getClient().getId());

        return dto;
    }

    public CreditPersonnel fromCreditPersonnelDTO(CreditPersonnelDTO dto, Client client) {
        CreditPersonnel entity = new CreditPersonnel();
        BeanUtils.copyProperties(dto, entity);
        entity.setClient(client);
        return entity;
    }

    // ===================== CREDIT IMMOBILIER =====================
    public CreditImmobilierDTO fromCreditImmobilier(CreditImmobilier credit) {
        CreditImmobilierDTO dto = new CreditImmobilierDTO();
        BeanUtils.copyProperties(credit, dto);

        if (credit.getClient() != null)
            dto.setClientId(credit.getClient().getId());

        return dto;
    }

    public CreditImmobilier fromCreditImmobilierDTO(CreditImmobilierDTO dto, Client client) {
        CreditImmobilier entity = new CreditImmobilier();
        BeanUtils.copyProperties(dto, entity);
        entity.setClient(client);
        return entity;
    }

    // ===================== CREDIT PROFESSIONNEL =====================
    public CreditProfessionnelDTO fromCreditProfessionnel(CreditProfessionnel credit) {
        CreditProfessionnelDTO dto = new CreditProfessionnelDTO();
        BeanUtils.copyProperties(credit, dto);

        if (credit.getClient() != null)
            dto.setClientId(credit.getClient().getId());

        return dto;
    }

    public CreditProfessionnel fromCreditProfessionnelDTO(CreditProfessionnelDTO dto, Client client) {
        CreditProfessionnel entity = new CreditProfessionnel();
        BeanUtils.copyProperties(dto, entity);
        entity.setClient(client);
        return entity;
    }

    // ===================== REMBOURSEMENT =====================
    public RemboursementDTO fromRemboursement(Remboursement r) {
        RemboursementDTO dto = new RemboursementDTO();
        BeanUtils.copyProperties(r, dto);

        if (r.getCredit() != null)
            dto.setCreditId(r.getCredit().getId());

        return dto;
    }
}