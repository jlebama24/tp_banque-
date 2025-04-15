package fr.javaEE;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String numero;
    private Double solde;

    @ManyToMany(mappedBy = "comptes")
    private List<Client> clients;

    /*
    On sait que un compte peut appartenir à plusieurs clients, et que 1 client peut avoir plusieurs comptes.
    De plus que la table Client va contenir la colonne "ID_COMPTE"
    Ce côté n’est pas propriétaire, c’est Client qui gère la jointure
     */
    public Compte() {

    }
    public Compte(Integer id, String numero, Double solde) {
        this.id = id;
        this.numero = numero;
        this.solde = solde;
    }

    public Compte(String numero, Double solde) {
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public Double getSolde() {
        return solde;
    }
    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public List<Client> getClients() {
        return clients;
    }
    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", solde=" + solde +
                ", clients=" + clients +
                '}';
    }
}
