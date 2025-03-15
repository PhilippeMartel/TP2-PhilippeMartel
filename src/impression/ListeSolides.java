package impression;

import solides.Cube;
import solides.Materiau;
import solides.Pyramide;
import solides.Solide;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Représente une liste de solides 3D.
 * Cette classe permet de charger des solides à partir d'un fichier CSV,
 * de trier les solides et d'exporter leur représentation au format STL.
 */
public class ListeSolides {

    private static final char fSep = File.separatorChar;
    private static final String pathOut = System.getProperty("user.dir") + fSep + "src" + fSep + "donneesSTL" + fSep;
    private List<Solide> solides;

    /**
     * Constructeur de la classe ListeSolides.
     * Initialise une nouvelle liste vide de solides.
     */
    public ListeSolides() {
        solides = new ArrayList<>();
    }

    /**
     * Obtient le chemin de sortie par défaut pour les fichiers STL.
     *
     * @return le chemin de sortie
     */
    public static String getPathOut() {
        return pathOut;
    }

    /**
     * Obtient la liste des solides.
     *
     * @return la liste des solides
     */
    public List<Solide> getSolides() {
        return solides;
    }

    /**
     * Charge des solides à partir d'un fichier CSV.
     * Chaque ligne du fichier doit spécifier le type de solide,
     * les dimensions et le matériau utilisé.
     *
     * @param file le fichier CSV à charger
     */
    public void chargerDepuisCSV(File file) {
        String ligne;
        Solide solide;

        try {
            BufferedReader fichier = new BufferedReader(new FileReader(file.getPath()));
            ligne = fichier.readLine(); // Ignorer l'en-tête
            ligne = fichier.readLine(); // Lire la première ligne de données

            while (ligne != null) {
                String[] stringTab = ligne.split("[,]");

                if (stringTab[0].equals("Cube")) {
                    solide = new Cube(Double.parseDouble(stringTab[1]), Materiau.valueOf(stringTab[3]));
                } else {
                    solide = new Pyramide(Double.parseDouble(stringTab[1]), Double.parseDouble(stringTab[2]), Materiau.valueOf(stringTab[3]));
                }

                solides.add(solide);
                ligne = fichier.readLine(); // Lire la prochaine ligne
            }

            fichier.close();
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e);
        }

        trier();
    }

    /**
     * Trie la liste des solides par volume croissant.
     */
    public void trier() {
        int indiceMin;

        for (int i = 0; i < solides.size() - 1; i++) {
            indiceMin = i;
            for (int j = i; j < solides.size(); j++) {
                if (((Solide) solides.get(indiceMin)).compareTo(solides.get(j)) == 1) {
                    indiceMin = j;
                }
            }
            solides.add(0, solides.remove(indiceMin));
        }
    }

    /**
     * Exporte tous les solides au format STL dans le chemin spécifié.
     *
     * @param pathOut le chemin où les fichiers STL seront exportés
     */
    public void exporterTousSTL(String pathOut) {
        for (int i = 0; i < solides.size(); i++) {
            Solide solide = solides.get(i);

            try {

                String s = "";

                if (solide.getClass() == Cube.class) {
                    s = "Cube";
                } else {
                    s = "Pyramide";
                }
                PrintWriter fichier = new PrintWriter(new FileWriter(pathOut + s + (i + 1) + ".stl"));

                fichier.print(solide.formaterSTL());
                fichier.flush();
                fichier.close();

            } catch (IOException e) {
                System.out.println("Écriture du fichier impossible : " + e);
            }
        }
    }
}