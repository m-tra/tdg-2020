package tga_algo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Chargement {
    private String nomgraphe;
    private Graphe graphelu;
    
    public Graphe Initialize(String ngraphe) {
        int nbsommets=0, nbarcs=0;
        
        Graphe nouveaugraphe = null;
        String s = "graphe " + ngraphe + ".txt";        
        try (Scanner parser = new Scanner(new FileReader("./graphes/"+s))) {
            ArrayList<Arc> arcs = new ArrayList<>();
            ArrayList<Sommet> sommets = new ArrayList<>();
            String tempsommets = parser.nextLine();
            String temparcs = parser.nextLine();
            int i = Integer.parseInt(temparcs);
            int a = Integer.parseInt(tempsommets);
            for (int j = 0; j < a; j++) {
                Sommet nouveausommet = new Sommet(j);
                sommets.add(nouveausommet);
            }
            for (int j = 0; j < i; j++) {
                String temparc = parser.nextLine();
                String[] split = temparc.split(" ");
                int pre = Integer.parseInt(split[0]);
                int suiv = Integer.parseInt(split[1]);
                int valeur = Integer.parseInt(split[2]);
                Arc nouvelarc = new Arc(pre, suiv, valeur);
                arcs.add(nouvelarc);
                sommets.get(pre).addSuiv(suiv);
                sommets.get(suiv).addPredec(pre);
            }
            nouveaugraphe = new Graphe(Integer.parseInt(tempsommets), Integer.parseInt(temparcs), arcs, sommets);
            nouveaugraphe.setSommets(sommets);
            nbarcs = nouveaugraphe.getNb_arcs();
            nbsommets = nouveaugraphe.getNb_sommets();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nouveaugraphe;
    }

    public String getNomgraphe() {
        return nomgraphe;
    }

    public void setNomgraphe(String nomgraphe) {
        this.nomgraphe = nomgraphe;
    }

    public Chargement(String ngraphe){
        this.nomgraphe = ngraphe;
        graphelu = Initialize(nomgraphe);
    }

    public Graphe getGraphelu() {
        return graphelu;
    }

    public void setGraphelu(Graphe graphelu) {
        this.graphelu = graphelu;
    }
    
    
}
