package tga_algo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ngraphe;
        Graphe actuel;
        Builder ecrit;
        do {
            System.out.println("Choisissez le graphe à traiter (entier entre 1 et 13)");
            ngraphe = in.nextLine();
            if (Integer.parseInt(ngraphe) > 13 || Integer.parseInt(ngraphe) < 1) {
                System.out.println("Choisissez un nombre entre 1 et 13");
            }
        } while (Integer.parseInt(ngraphe) > 13 || Integer.parseInt(ngraphe) < 1);
        Chargement nvgraphe = new Chargement(ngraphe);
        actuel = nvgraphe.getGraphelu();
        ecrit = new Builder(actuel, ngraphe);
        ecrit.carac();        
        ecrit.arcs();
        System.out.println("Ecriture du tableau 2D dans le fichier");
        ecrit.matrices();
        
        System.exit(0);
    }
}
