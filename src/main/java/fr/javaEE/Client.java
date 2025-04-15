package fr.javaEE;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;
    private String prenom;

    @Embedded
    private Adresse adresse;

    /*
    Cela signifie que les champs de la classe Adresse vont être intégrés dans la table Client

    Il ne va pas y avoir de table Adresse, mais directement des colonnes comme adresse_rue, adresse_ville, etc. dans la table client.

    Utilisé pour des objets simples, sans identité propre.
     */

    @ManyToOne
    @JoinColumn(name = "ID_BANQUE")
    private Banque banque;


    /*
    Relation plusieurs clients → 1 banque

    Cela ajoute une colonne ID_BANQUE dans la table client

    Cette colonne est une clé étrangère qui pointe vers une ligne dans la table banque

    Ce client est rattaché à une seule banque (via la colonne ID_BANQUE)
     */

    @ManyToMany
    @JoinTable(
            name = "CLIENT_COMPTE",
            joinColumns = @JoinColumn(name = "ID_CLIENT"),
            inverseJoinColumns = @JoinColumn(name = "ID_COMPTE")
    )

    /*
    C’est une relation many-to-many :

    Un client peut avoir plusieurs comptes

     Et un compte peut appartenir à plusieurs clients

     Problème relationnel : on ne peut pas faire ça directement dans une seule table.

     Solution :
     Créer une table d'association CLIENT_COMPTE qui contient :

     ID_CLIENT (clé étrangère vers client)

     ID_COMPTE (clé étrangère vers compte)
     */

    private List<Compte> comptes;

    public Client() {}

    public Client(String nom, String prenom, Adresse adresse, Banque banque) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.banque = banque;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse=" + adresse +
                ", banque=" + banque +
                ", comptes=" + comptes +
                '}';
    }
}
