package fr.javaEE;

import jakarta.persistence.*;

@Entity
@Table(name = "virement")
public class Virement extends Operation {

    private String beneficiaire;

    public Virement() {}

    public Virement(double montant, String motif, java.time.LocalDateTime date, Compte compte, String beneficiaire) {
        super(montant, motif, date, compte);
        this.beneficiaire = beneficiaire;
    }

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    @Override
    public String toString() {
        return super.toString() + ", Virement{" +
                "beneficiaire='" + beneficiaire + '\'' +
                '}';
    }
}
