package impression;

import solides.Cube;
import solides.Materiau;
import solides.Pyramide;
import solides.Solide;

import java.io.*;
import java.util.List;


public class ListeSolides {

    private static final char fSep = File.separatorChar;
    private static final String pathOut = System.getProperty("user.dir") + fSep + "src" + fSep + "donneesSTL" + fSep;
    private List<Solide> solides;

    public ListeSolides() {

    }

    public String getPathOut() {
        return pathOut;
    }

    public List<Solide> getSolides() {
        return solides;
    }

    public void chargerDepuisCSV(File file) {
        String ligne;
        Solide solide;

        try {
            BufferedReader fichier = new BufferedReader(new FileReader(file.getPath()));
            ligne = fichier.readLine();
            ligne = fichier.readLine();

            while (ligne != null) {
                String[] stringTab = ligne.split("[,]");

                if (stringTab[0] == "Cube") {
                    solide = new Cube(Double.parseDouble(stringTab[1]), Materiau.valueOf(stringTab[3]));
                } else {
                    solide = new Pyramide(Double.parseDouble(stringTab[1]), Double.parseDouble(stringTab[2]), Materiau.valueOf(stringTab[3]));
                }

                solides.add(solide);
                // On lit la prochaine ligne
                ligne = fichier.readLine();
            }

            fichier.close();
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e);
        }
    }

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

    public void exporterTousSTL(String pathOut) {

        for (int i = 0; i < solides.size(); i++) {
            Solide solide = solides.get(i);

            try {
                PrintWriter fichier = new PrintWriter(new FileWriter(pathOut + solide.getClass().toString() + "1.stl"));

                fichier.print(solide.formaterSTL());
                fichier.flush();
                fichier.close();

            } catch (IOException e) {
                System.out.println("Écriture du fichier impossible : " + e);
            }
        }

    }

}
