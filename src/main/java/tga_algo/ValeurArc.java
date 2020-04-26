package tga_algo;

public class ValeurArc {

    public static boolean valeurexterieur(Graphe graphe) {
        int valeur = 0, cpt = 0;
        for (int i = 0; i < graphe.getNb_sommets(); i++) {
            for (int j = 0; j < graphe.getNb_arcs(); j++) {
                if (graphe.getArcs().get(j).getDebut() == i) {
                    if (cpt != 0) {
                        if (graphe.getArcs().get(j).getValeur() != valeur) {
                            return false;
                        }
                    }
                    cpt++;
                    valeur = graphe.getArcs().get(j).getValeur();
                }
            }
            cpt = 0;
        }
        return true;
    }

    public static boolean valeurnegtive(Graphe graphe) {
        for (int i = 0; i < graphe.getNb_sommets(); i++) {
            if(graphe.getArcs().get(i).getValeur()<0)
                return false;
        }
        return true;
    }
}
