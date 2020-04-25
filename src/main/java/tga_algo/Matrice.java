package tga_algo;

import java.util.Arrays;


public class Matrice {

    private Graphe graphe;
    private int[][] adjacence;
    private String[][] valeurs;

    public void setGraphe(Graphe graphe) {
        this.graphe = graphe;
    }
    
    public int getTaille(){
        int taillem = this.graphe.getNb_sommets();
        return taillem;
    }

    public int[][] calculadj() {
        int[][] matrice;
        int taille = graphe.getNb_sommets();
        System.out.println(taille);
        matrice = new int[taille][taille];
        for (int i = 0; i < graphe.getNb_arcs(); i++) {
            int a = graphe.getArcs().get(i).getDebut();//lecture du sommet de départ de l'arc
            int b = graphe.getArcs().get(i).getFin();//lecture du sommet d'arrivée de l'arc
            matrice[a][b] = 1;
            matrice[b][a] = 1;
        }
        System.out.println("la longueur est");
        System.out.println(matrice.length);
        return matrice;
    }

    public String[][] calculval() {
        String[][] matrice;
        int taille = graphe.getNb_sommets();
        matrice = new String[taille][taille];
        for(int i = 0; i< taille; i++)
        {
            for(int j = 0; j< taille; j++){
                matrice[i][j] ="_";
            }
        }
        for (int i = 0; i < graphe.getNb_arcs(); i++) {
            int val = graphe.getArcs().get(i).getValeur();
            System.out.print("la valeur de l'arc est : ");
            System.out.println(val);
            int a = graphe.getArcs().get(i).getDebut();//lecture du sommet de départ de l'arc
            int b = graphe.getArcs().get(i).getFin();//lecture du sommet d'arrivée de l'arc
            matrice[a][b] = Integer.toString(val);
            matrice[b][a] = matrice[a][b];
        }
        return matrice;
    }

}
