package fr.javaEE;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class LivretA extends Compte {

    private double taux;

    public LivretA() {}

    public LivretA(String numero, Double solde, double taux) {
        super(numero, solde);
        this.taux = taux;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        return super.toString() + ", LivretA{" + "taux=" + taux + '}';
    }
}
