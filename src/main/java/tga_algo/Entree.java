package tga_algo;


public class Entree {
    public static int nb_p_entree(Graphe graphe) {
        int nb_entrees = 0;
        int nb_sommets;
        nb_sommets = graphe.getNb_sommets();
        for (int i = 0; i < nb_sommets; i++) {
            if (graphe.getSommets().get(i).getPredec().isEmpty()) {
                nb_entrees++;
            }
        }

        return nb_entrees;
    }
    
    public static boolean Nb_entrees(Graphe graphe) {

        if (Entree.nb_p_entree(graphe) == 1) {
            System.out.println("il y a qu'une entree");
            return true;
        }
        System.out.println("il y a plus d'une entree");
        return false;
    }
    
    public static boolean Incidence (Graphe graphe){
        int entree = 0; //valeur par défaut mais peut changer en fonction du graphe
        boolean verif=false;
        for(int i=0; i<graphe.getNb_sommets(); i++){
            if (graphe.getSommets().get(i).getPredec().isEmpty()) {
                entree = graphe.getSommets().get(i).getValeur();
            }
        }
        for(int i =0; i<graphe.getNb_arcs(); i++){
            if(graphe.getArcs().get(i).getDebut()==entree){
                if(graphe.getArcs().get(i).getValeur()!=0){
                   verif = false;
                }
                else
                   verif = true;
            }
        }
        System.out.println(verif);
        return verif;
    }
}
