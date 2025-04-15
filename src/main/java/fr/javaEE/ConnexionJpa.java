package fr.javaEE;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ConnexionJpa {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // --- Créer une banque ---
        Banque banque = new Banque();
        banque.setNom("Banque Nationale");
        em.persist(banque);

        // --- Créer une adresse ---
        Adresse adresse = new Adresse();
        adresse.setNumero(12);
        adresse.setRue("Rue des Lilas");
        adresse.setCodePostal("75000");
        adresse.setVille("Paris");

        // --- Créer un client ---
        Client client = new Client();
        client.setNom("Lebama");
        client.setPrenom("Jacques Junior");
        client.setAdresse(adresse);
        client.setBanque(banque);
        // Pas de persist(client) ici pour ne pas casser les relations suivantes

        // --- Créer les comptes ---
        Compte compte = new Compte();
        compte.setNumero("CPT123456");
        compte.setSolde(1500.0);

        LivretA livretA = new LivretA("LIV123", 2000.0, 1.75);

        Courant courant = new Courant("CC123", 800.0, 300.0);

        AssuranceVie assurance = new AssuranceVie("AV456", 5000.0, LocalDate.of(2030, 12, 31), 2.5);

        // --- Lier les comptes au client et vice versa ---
        List<Compte> comptes = List.of(compte, livretA, courant, assurance);
        client.setComptes(comptes);

        compte.setClients(List.of(client));
        livretA.setClients(List.of(client));
        courant.setClients(List.of(client));
        assurance.setClients(List.of(client));

        // --- Créer une opération (virement) sur un compte ---
        Virement virement = new Virement();
        virement.setMontant(150.0);
        virement.setMotif("Paiement loyer");
        virement.setDate(LocalDateTime.now());
        virement.setBeneficiaire("Monsieur Dupont");
        virement.setCompte(compte);

        // --- Persist de toutes les entités ---
        em.persist(compte);
        em.persist(livretA);
        em.persist(courant);
        em.persist(assurance);
        em.persist(client);
        em.persist(virement);

        em.getTransaction().commit();
        em.close();
        emf.close();

        System.out.println("✅ Données enregistrées avec succès !");
    }
}
