package tga_algo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String exit = "1";
        do {
            String ngraphe;
            Graphe actuel;
            Builder ecrit;
            System.out.println("Entrez un caractère pour continuer et tapez 0 pour quitter et tapez -1 pour exécuter le programme pour tous les graphes");
            System.out.println("Tapez -2 pour avoir toutes les traces d'éxecution dans le même fichier");
            ngraphe = in.nextLine();
            if (!ngraphe.equals("0") && !ngraphe.equals("-1")&&!ngraphe.equals("-2")) {
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
                ecrit.Circuit();
                System.out.println("\n");
                ecrit.calculRang();
                ecrit.Ordonnacement();

            } else if (ngraphe.equals("-1")) {
                for (int i = 1; i < 14; i++) {
                    Chargement nvgraphe = new Chargement(String.valueOf(i));
                    actuel = nvgraphe.getGraphelu();
                    ecrit = new Builder(actuel, String.valueOf(i));
                    ecrit.carac();
                    ecrit.arcs();
                    System.out.println("Ecriture du tableau 2D dans le fichier");
                    ecrit.matrices();
                    ecrit.Circuit();
                    System.out.println("\n");
                    ecrit.calculRang();
                    ecrit.Ordonnacement();
                }
            }else if (ngraphe.equals("-2")){
                for (int i = 1; i < 14; i++) {
                    Chargement nvgraphe = new Chargement(String.valueOf(i));
                    actuel = nvgraphe.getGraphelu();
                    ecrit = new Builder(actuel, " complet");
                    ecrit.carac();
                    ecrit.arcs();
                    System.out.println("Ecriture du tableau 2D dans le fichier");
                    ecrit.matrices();
                    ecrit.Circuit();
                    System.out.println("\n");
                    ecrit.calculRang();
                    ecrit.Ordonnacement();
                }
            } 
            else {
                System.exit(0);
            }
        } while (!exit.equals("0"));
    }

}
