package tga_algo;

import java.io.Serializable;

public class Arc implements Serializable{
    private int debut;
    private int fin;
    private int valeur;

    public int getDebut() {
        return debut;
    }

    public void setDebut(int debut) {
        this.debut = debut;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public Arc() {
    }

    public Arc(int debut, int fin, int valeur) {
        this.debut = debut;
        this.fin = fin;
        this.valeur = valeur;
    }

    
}
