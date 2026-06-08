package com.example.backend;

import com.example.backend.entities.Client;
import com.example.backend.entities.CreditPersonnel;
import com.example.backend.entities.CreditImmobilier;
import com.example.backend.entities.Remboursement;
import com.example.backend.enums.StatutCredit;
import com.example.backend.enums.TypeRemboursement;
import com.example.backend.repository.ClientRepository;
import com.example.backend.repository.CreditRepository;
import com.example.backend.repository.RemboursementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataInitializer(
			ClientRepository clientRepository,
			CreditRepository creditRepository,
			RemboursementRepository remboursementRepository) {

		return args -> {
			remboursementRepository.deleteAll();
			creditRepository.deleteAll();
			clientRepository.deleteAll();

			// 1. Création du client (Le builder standard fonctionne parfaitement ici)
			Client client = Client.builder()
					.nom("Hugues")
					.email("hugues@gmail.com")
					.build();
			clientRepository.save(client);

			// 2. Création du Crédit Personnel via le constructeur explicite
			CreditPersonnel creditPersonnel = new CreditPersonnel();
			creditPersonnel.setClient(client);
			creditPersonnel.setDateDemande(new Date());
			creditPersonnel.setStatut(StatutCredit.EN_COURS);
			creditPersonnel.setMontant(100000);
			creditPersonnel.setDureeRemboursement(60);
			creditPersonnel.setTauxInteret(5.5);
			creditPersonnel.setMotif("Achat voiture"); // Plus d'erreur de compilation !
			creditRepository.save(creditPersonnel);

			// 3. Création du Crédit Immobilier via le constructeur explicite
			CreditImmobilier creditImmobilier = new CreditImmobilier();
			creditImmobilier.setClient(client);
			creditImmobilier.setDateDemande(new Date());
			creditImmobilier.setStatut(StatutCredit.ACCEPTE);
			creditImmobilier.setDateAcceptation(new Date());
			creditImmobilier.setMontant(500000);
			creditImmobilier.setDureeRemboursement(240);
			creditImmobilier.setTauxInteret(4.2);
			creditImmobilier.setTypeBien("Appartement"); // Plus d'erreur de compilation !
			creditRepository.save(creditImmobilier);

			// 4. Création du Remboursement lié au Crédit Immobilier
			Remboursement remboursement = Remboursement.builder()
					.date(new Date())
					.montant(5000)
					.type(TypeRemboursement.MENSUALITE)
					.credit(creditImmobilier)
					.build();
			remboursementRepository.save(remboursement);

			System.out.println("=========================================");
			System.out.println("  JEU DE DONNÉES DE TEST INITIALISÉ !    ");
			System.out.println("=========================================");
		};
	}
}