package fr.javaEE;
import jakarta.persistence.*;

@Embeddable
public class Adresse {

    private Integer numero;
    private String rue;
    private String codePostal;
    private String ville;

    public Adresse() {
    }

    public Adresse(Integer numero, String rue, String codePostal, String ville) {
        this.numero = numero;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    // Getters & Setters
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return numero + " " + rue + ", " + codePostal + " " + ville;
    }
}