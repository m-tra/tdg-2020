package tga_algo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Builder {

    private WriteFile resultat;
    private StringBuilder builder;
    private Graphe graphe;
    private int nbarcs;
    private int nbsommets;
    private boolean presencecircuit;

    public Builder(Graphe graphe, String ngraphe) {
        this.graphe = graphe;
        resultat = new WriteFile("./resultats/resultat graphe" + ngraphe + ".txt");
        nbarcs = graphe.getNb_arcs();
        nbsommets = graphe.getNb_sommets();
    }

    public Graphe getGraphe() {
        return graphe;
    }

    public void setGraphe(Graphe graphe) {
        this.graphe = graphe;
    }

    public void carac() {
        try {
            resultat.writetoFile(String.valueOf(nbsommets) + " sommets");
            resultat.writetoFile(String.valueOf(nbarcs) + " arcs");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void arcs() {
        for (int i = 0; i < nbarcs; i++) {
            try {
                String debut = String.valueOf(graphe.getArcs().get(i).getDebut());
                String fin = String.valueOf(graphe.getArcs().get(i).getFin());
                String valeur = String.valueOf(graphe.getArcs().get(i).getValeur());
                resultat.writetoFile(debut + " -> " + fin + " = " + valeur);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void matrices() {
        Matrice matrice = new Matrice();
        builder = new StringBuilder();
        int[][] adj;
        String[][] val;
        matrice.setGraphe(graphe);
        adj = matrice.calculadj();
        val = matrice.calculval();
        builder.append("\n").append("\t");
        for (int i = 0; i < adj.length; i++) {
            builder.append(i).append("\t");
        }
        builder.append("\n");
        for (int i = 0; i < adj.length; i++) {
            builder.append(i).append("\t");
            for (int j = 0; j < adj.length; j++) {
                builder.append(adj[i][j]).append("");
                if (j < adj.length - 1) {
                    builder.append("\t");
                }
            }
            builder.append("\n");
        }
        try {
            resultat.writetoFile(builder.toString());
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        builder.setLength(0);
        builder.append("\t");
        for (int i = 0; i < val.length; i++) {
            builder.append(i).append("\t");
        }
        builder.append("\n");
        for (int i = 0; i < val.length; i++) {
            builder.append(i).append("\t");
            for (int j = 0; j < val.length; j++) {
                builder.append(val[i][j]).append("");
                if (j < adj.length - 1) {
                    builder.append("\t");
                }
            }
            builder.append("\n");
        }
        try {
            resultat.writetoFile(builder.toString());
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Circuit() {
        builder = new StringBuilder();
        Graphe clone = DeepCopy.copy(graphe);
        Circuit circuit = new Circuit();
        builder.append("\n");
        if (circuit.exist_cicruit(graphe) == true) {
            System.out.println("il y a au moins un circuit");
            builder.append("Il y a au moins un circuit");
            presencecircuit = true;
        } else {
            System.out.println("il n'y a pas de circuit");
            presencecircuit = false;
        }
        try {
            resultat.writetoFile(builder.toString());
        } catch (IOException ex) {
            Logger.getLogger(Builder.class.getName()).log(Level.SEVERE, null, ex);
        }
        graphe = clone;
    }

    public void calculRang() {
        builder = new StringBuilder();
        Graphe clone = DeepCopy.copy(graphe);
        ArrayList<ArrayList<Integer>> rangs;
        rangs = Rang.rang(clone);
        builder.append("\n");
        for (int i = 0; i < rangs.size() - 1; i++) {
            builder.append("rang ").append(i+1).append(" :");
            builder.append(rangs.get(i)).append("\n");
        }
        try {
            resultat.writetoFile(builder.toString());
        } catch (IOException ex) {
            Logger.getLogger(Builder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Ordonnacement() {
        builder = new StringBuilder();
        boolean entrees = Entree.Nb_entrees(graphe);
        System.out.println("entree " + entrees + "\n");
        boolean sorties = Sortie.Nb_sorties(graphe);
        System.out.println("sorties " + sorties + "\n");
        boolean verifentree = Entree.Incidence(graphe);
        System.out.println("verifentreee " + verifentree + "\n");
        builder.append("\n");
        boolean valeurarc = ValeurArc.valeurexterieur(graphe);
        System.out.println("valeurarc " + valeurarc);
        boolean negatif = ValeurArc.valeurnegtive(graphe);
        System.out.println("arcnegatif "+ negatif);
        if (entrees == false) {
            builder.append("Il y a plus d'une entree\n");
        } else {
            builder.append("Il n'y a qu'une entree\n");
        }
        if (sorties == false) {
            builder.append("Il y a plus d'une sortie\n");
        } else {
            builder.append("Il n'y a qu'une sortie\n");
        }
        if (verifentree == false) {
            builder.append("Un ou plusieurs arcs incidents vers l’extérieur au point d’entrée ne sont pas de valeur nulle\n");
        } else {
            builder.append("Les arcs incidents vers l’extérieur au(x) point(s) d’entrée sont de valeur nulle\n");
        }
        if (valeurarc == false) {
            builder.append("Les valeurs ne sont pas identiques pour tous les arcs incidents vers l’extérieur à un sommet\n");
        } else {
            builder.append("Les valeurs sont identiques pour tous les arcs incidents vers l’extérieur à un sommet\n");
        }
        if(negatif == false)
            builder.append("Le graphe possède un ou plusieurs arc(s) avec des valeurs négatives\n");
        else
            builder.append("Le graphe ne possède aucun arc avec une valeur négative\n");
        
        if(entrees && sorties && verifentree && valeurarc && negatif)
            builder.append("Le graphe est un graphe d'ordonnancement correct \n");
        else
            builder.append("Le graphe n'est pas un graphe d'ordonnancement correct\n");
        
        try {
            resultat.writetoFile(builder.toString());
        } catch (IOException ex) {
            Logger.getLogger(Builder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
