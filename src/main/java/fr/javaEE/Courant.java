package fr.javaEE;

import jakarta.persistence.*;

@Entity
public class Courant extends Compte {

    private double decouvert;

    public Courant() {}

    public Courant(String numero, Double solde, double decouvert) {
        super(numero, solde);
        this.decouvert = decouvert;
    }

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }

    @Override
    public String toString() {
        return super.toString() + ", Courant{" + "découvert=" + decouvert + '}';
    }
}
