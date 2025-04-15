package fr.javaEE;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import fr.javaEE.Client;


@Entity

public class Banque implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;

    @OneToMany(mappedBy = "banque")
    private List<Client> clients;

    /*
    Une banque peut - être associée à plusieurs clients
    Chaque client appartient à une banque
    1 banque → N clients
    mappedBy = "banque" veut dire que l'attribut banque dans la classe Client est le propriétaire de la relation.
    « Ce n’est pas la table Banque qui contient la clé étrangère,
    mais la table Client qui contient la colonne ID_BANQUE ».

    Donc Hibernate :

    ne crée pas de colonne supplémentaire dans Banque

    mais comprend que la relation est déjà gérée depuis Client

     */

    public Banque() {}
    public Banque(Integer id, String nom) {
        this.id = id;
        this.nom = nom;
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
    public List<Client> getClients() {
        return clients;
    }



    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
    @Override
    public String toString() {
        return "Banque{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", clients=" + clients +
                '}';
    }
}
