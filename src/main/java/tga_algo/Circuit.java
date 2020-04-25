package tga_algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Circuit {

    public Circuit() {
    }

    public boolean exist_cicruit(Graphe graphe) {
        List<Integer> rmv = new ArrayList<>();
        SommetVide S = new SommetVide();
        do {
            rmv.clear();
            for (int i = 0; i < graphe.getSommets().size(); i++) {
                if (graphe.getSommets().get(i).getPredec().isEmpty()) {
                    rmv.add(graphe.getSommets().get(i).getValeur());
                } else if (graphe.getSommets().get(i).getSuiv().isEmpty()) {
                    rmv.add(graphe.getSommets().get(i).getValeur());
                }
            }
            for (int i = 0; i < graphe.getSommets().size(); i++) {
                for (int j = 0; j < rmv.size(); j++) {
                    graphe.getSommets().get(i).removePre(rmv.get(j));
                    graphe.getSommets().get(i).removeSuiv(rmv.get(j));
                }
            }
            System.out.println(graphe.getSommets().size());
            for (int j = 0; j < graphe.getSommets().size(); j++) {
                for (int i = 0; i < rmv.size(); i++) {
                    if (graphe.getSommets().get(j).getValeur() == rmv.get(i)) {
                            graphe.getSommets().set(j, S);
                    }
                }
            }
            graphe.getSommets().removeAll(Collections.singleton(S));
            System.out.println("rmv " + rmv);
        } while (!rmv.isEmpty());
        if (graphe.getSommets().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
