package tga_algo;

import java.util.*;

public class Circuit {

    public Circuit() {
    }

    public boolean exist_cicruit(Graphe graphe) {
        int nb_sommets;
        ArrayList<Integer> enlever = new ArrayList<>();
        nb_sommets = graphe.getNb_sommets();
        if (nb_sommets <= 0) {
            return false;
        }
        for (int i = 0; i < nb_sommets; i++) {
            if (graphe.getSommets().get(i).getPredec().isEmpty() || graphe.getSommets().get(i).getSuiv().isEmpty()) {
                enlever.add(i);
            }
        }
        if (!enlever.isEmpty()) {
            for (int i = 0; i < enlever.size(); i++) {
                graphe.getSommets().remove(i);
            }
        }
        if (graphe.getNb_sommets() == nb_sommets) {
            return true;
        }
        return exist_cicruit(graphe);
    }
}
