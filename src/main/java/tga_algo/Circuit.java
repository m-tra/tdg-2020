package tga_algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Circuit {

    public Circuit() {
    }

    public boolean exist_cicruit(Graphe actual) {
        Graphe temp = actual;
        List<Integer> rmv = new ArrayList<>();
        SommetVide S = new SommetVide();
        do {
            rmv.clear();
            for (int i = 0; i < actual.getSommets().size(); i++) {
                if (actual.getSommets().get(i).getPredec().isEmpty()) {
                    rmv.add(actual.getSommets().get(i).getValeur());
                } else if (actual.getSommets().get(i).getSuiv().isEmpty()) {
                    rmv.add(actual.getSommets().get(i).getValeur());
                }
            }
            for (int i = 0; i < actual.getSommets().size(); i++) {
                for (int j = 0; j < rmv.size(); j++) {
                    actual.getSommets().get(i).removePre(rmv.get(j));
                    actual.getSommets().get(i).removeSuiv(rmv.get(j));
                }
            }
            System.out.println(actual.getSommets().size());
            for (int j = 0; j < actual.getSommets().size(); j++) {
                for (int i = 0; i < rmv.size(); i++) {
                    if (actual.getSommets().get(j).getValeur() == rmv.get(i)) {
                            actual.getSommets().set(j, S);
                    }
                }
            }
            actual.getSommets().removeAll(Collections.singleton(S));
            System.out.println("rmv " + rmv);
        } while (!rmv.isEmpty());
        if (actual.getSommets().isEmpty()) {
            actual = temp;
            return false;
        } else {
            actual=temp;
            return true;
        }
    }
}
