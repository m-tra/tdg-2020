package tga_algo;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Builder {

    private WriteFile resultat;
    private StringBuilder builder;
    private Graphe graphe;
    private int nbarcs;
    private int nbsommets;

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

    public Builder() {
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
        builder.append("\n").append("  ");
        for (int i = 0; i < adj.length; i++) {
            builder.append(i).append(" ");
        }
        builder.append("\n");
        for (int i = 0; i < adj.length; i++) {
            builder.append(i).append(" ");
            for (int j = 0; j < adj.length; j++) {
                builder.append(adj[i][j]).append("");
                if (j < adj.length - 1) {
                    builder.append(" ");
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
        builder.append("  ");
        for (int i = 0; i < val.length; i++) {
            builder.append(i).append(" ");
        }
        builder.append("\n");
        for (int i = 0; i < val.length; i++) {
            builder.append(i).append(" ");
            for (int j = 0; j < val.length; j++) {
                builder.append(val[i][j]).append("");
                if (j < adj.length - 1) {
                    builder.append(" ");
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
    public void Circuit(){
        Circuit circuit = new Circuit();
        if(circuit.exist_cicruit(graphe) == true)
            System.out.println("il y a un circuit");
        else
            System.out.println("il n'y a pas de circuit");
        
    }
}