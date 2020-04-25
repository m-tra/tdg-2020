package tga_algo;

import java.util.ArrayList;
public class Graphe {
    private int nb_sommets;
    private int nb_arcs;
    private ArrayList<Arc> arcs;
    private ArrayList<Sommet> sommets;

    public int getNb_sommets() {
        return nb_sommets;
    }

    public void setNb_sommets(int nb_sommets) {
        this.nb_sommets = nb_sommets;
    }

    public int getNb_arcs() {
        return nb_arcs;
    }

    public void setNb_arcs(int nb_arcs) {
        this.nb_arcs = nb_arcs;
    }

    public ArrayList<Arc> getArcs() {
        return arcs;
    }

    public void setArcs(ArrayList<Arc> arcs) {
        this.arcs = arcs;
    }

    public ArrayList<Sommet> getSommets() {
        return sommets;
    }

    public void setSommets(ArrayList<Sommet> sommets) {
        this.sommets = sommets;
    }
    
    
    public Graphe(int nb_sommets, int nb_arcs, ArrayList<Arc> arcs, ArrayList<Sommet> sommets) {
        this.nb_sommets = nb_sommets;
        this.nb_arcs = nb_arcs;
        this.arcs = arcs;
        this.sommets = sommets;
    }
    
    

}
