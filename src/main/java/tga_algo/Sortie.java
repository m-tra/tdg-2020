package tga_algo;

public class Sortie {

    public static int nb_p_sorties(Graphe graphe) {
        int nb_sorties = 0;
        int nb_sommets;
        nb_sommets = graphe.getNb_sommets();

        for (int i = 0; i < nb_sommets; i++) {
            if (graphe.getSommets().get(i).getSuiv().isEmpty()) {

                nb_sorties++;
            }
        }

        return nb_sorties;
    }
    
    public static boolean Nb_sorties(Graphe graphe) {

        if (Sortie.nb_p_sorties(graphe) == 1) {
            System.out.println("il y a une sortie");
            return true;
        }
        System.out.println("il y a plus d'une sortie");
        return false;

    }
}
