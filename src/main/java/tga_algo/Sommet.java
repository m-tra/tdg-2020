package tga_algo;

import java.util.ArrayList;

public class Sommet {

    private ArrayList<Integer> predec;
    private ArrayList<Integer> suiv;
    private int valeur;

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public Sommet() {
        predec = new ArrayList<>();
        suiv = new ArrayList<>();
    }

    public void addPredec(int pre) {
        this.predec.add(pre);

    }

    public void addSuiv(int suiv) {
        this.suiv.add(suiv);
    }

    public ArrayList<Integer> getPredec() {
        return predec;
    }

    public ArrayList<Integer> getSuiv() {
        return suiv;
    }

    public void removePre(Integer element) {
        int index;
        while ((index = predec.indexOf(element)) >= 0) {
            predec.remove(index);
        }
    }

    public void removeSuiv(Integer element) {
        int index;
        while((index = suiv.indexOf(element))>=0){
            suiv.remove(index);
        }
    }

    public Sommet(int valeur) {
        this.valeur = valeur;
        predec = new ArrayList<>();
        suiv = new ArrayList<>();
    }

}
