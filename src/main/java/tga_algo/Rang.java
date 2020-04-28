package tga_algo;

import java.util.ArrayList;
import java.util.Collections;

public class Rang {
    public Rang() {
    }
    public static ArrayList<ArrayList<Integer>> rang(Graphe actual){
        ArrayList<ArrayList<Integer>> rangs = new ArrayList<>();
        ArrayList<Integer> rmv;
        SommetVide S = new SommetVide();
        do {
            rmv = new ArrayList<>();
            for (int i = 0; i < actual.getSommets().size(); i++) {
                if (actual.getSommets().get(i).getPredec().isEmpty()) {
                    rmv.add(actual.getSommets().get(i).getValeur());
                } 
            }
            for (int i = 0; i < actual.getSommets().size(); i++) {
                for (int j = 0; j < rmv.size(); j++) {
                    actual.getSommets().get(i).removePre(rmv.get(j));
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
            rangs.add(rmv);
        } while (!rmv.isEmpty());
        for(int i =0; i<rangs.size(); i++){
            System.out.println("rang "+ i + " "+rangs.get(i));
        }
        return rangs;
    }

}
