package tests;

import impression.FileAttente;
import impression.ListeSolides;
import org.junit.jupiter.api.BeforeEach;
import solides.*;
import solides.Materiau;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Tp2Test {

    Cube solide1;
    Pyramide solide2;
    Cube solide3;
    Pyramide solide4;
    ListeSolides listeSolides;
    private static final char fSep = File.separatorChar;
    private FileAttente fileAttente;


    @BeforeEach
    public void setUp() {
        // Initialisation d'un nouvel objet ListeSolides avant chaque test
        listeSolides = new ListeSolides();
        solide1 = new Cube();
        solide2 = new Pyramide();
        solide3 = new Cube(6, Materiau.PLA);
        solide4 = new Pyramide(7, 8, Materiau.PETG);
        fileAttente = new FileAttente();
    }

    @Test
    void constructeurCubeDefaut() {
        assertTrue(solide1.getCote() == 5 && solide1.getMateriau() == Materiau.NYLON);
    }

    @Test
    void constructeurCubeValide() {
        assertTrue(solide3.getCote() == 6 && solide3.getMateriau() == Materiau.PLA);
    }

    @Test
    void constructeurCubeinvalide() {
        assertThrows(IllegalArgumentException.class, () -> new Cube(-3, Materiau.NYLON));
    }

    @Test
    void constructeurPyramideDefaut() {
        assertTrue(solide2.getCoteBase() == 5 && solide2.getHauteur() == 10 && solide2.getMateriau() == Materiau.NYLON);
    }

    @Test
    void constructeurPyramideValide() {
        assertTrue(solide4.getCoteBase() == 7 && solide4.getHauteur() == 8 && solide4.getMateriau() == Materiau.PETG);
    }

    @Test
    void constructeurPyramideInvalide() {
        assertThrows(IllegalArgumentException.class, () -> new Pyramide(-3, 64, Materiau.NYLON));
    }

    @Test
    void getMateriau() {
        assertEquals(solide1.getMateriau(), Materiau.NYLON);
    }

    @Test
    void setMateriauValide() {
        solide1.setMateriau(Materiau.PLA);
        assertEquals(solide1.getMateriau(), Materiau.PLA);
    }

    @Test
    void setMateriauInvalide() {
        assertThrows(IllegalArgumentException.class, () -> solide1.setMateriau(null));
    }

    @Test
    void compareToPetit() {
        assertEquals(solide1.compareTo(solide3), -1);
    }

    @Test
    void compareToGrand() {
        assertEquals(solide4.compareTo(solide1), 1);
    }

    @Test
    void compareToEgale() {
        assertEquals(solide1.compareTo(solide1), 0);
    }

    @Test
    void testToString() {
        assertEquals(solide1.toString(), "Cube (volume = 125)");
    }

    @Test
    void getCote() {
        assertEquals(solide1.getCote(), 5);
    }

    @Test
    void setCoteValide() {
        solide1.setCote(7);
        assertTrue(solide1.getCote() == 7);
    }

    @Test
    void setCoteInvalide() {
        assertThrows(IllegalArgumentException.class, () -> solide1.setCote(73));
    }

    @Test
    void getCoteBase() {
        assertEquals(solide2.getCoteBase(), 5);
    }

    @Test
    void getHauteur() {
        assertEquals(solide2.getHauteur(), 10);
    }

    @Test
    void setCoteBaseValide() {
        solide2.setCoteBase(7);
        assertTrue(solide2.getCoteBase() == 7);
    }

    @Test
    void setCoteBaseInvalide() {
        assertThrows(IllegalArgumentException.class, () -> solide2.setCoteBase(73));
    }

    @Test
    void setHauteurValide() {
        solide2.setHauteur(7);
        assertTrue(solide2.getHauteur() == 7);
    }

    @Test
    void setHauteurInvalide() {
        assertThrows(IllegalArgumentException.class, () -> solide2.setHauteur(73));
    }

    @Test
    void calculerSurfaceCube() {
        assertEquals(solide1.calculerSurface(), 150);
    }

    @Test
    void calculerSurfacePyramide() {
        assertTrue(solide2.calculerSurface() == ((Math.sqrt(Math.pow((double)(5 / 2), 2) + Math.pow(10, 2) * 5) / 2) * 4) + 25);
    }

    @Test
    void calculerVolumeCube() {
        assertEquals(solide1.calculerVolume(), 125);
    }

    @Test
    void calculerVolumePyramide() {
        assertTrue(solide1.calculerVolume() == (double)(250 / 3));
    }


    @Test
    public void testConstructeurListeSolides() {
        assertNotNull(listeSolides.getSolides());
        assertTrue(listeSolides.getSolides().isEmpty());
    }

    @Test
    public void ChargerDepuisCSV() throws IOException {
        File file = new File(System.getProperty("user.dir") + fSep + "src" + fSep + "donneesCSV" + fSep + "exemple.csv");

        listeSolides.chargerDepuisCSV(file);

        List<Solide> solides = listeSolides.getSolides();
        assertEquals(4, solides.size());

        assertEquals(solides.get(0), new Pyramide(4, 22, Materiau.ABS));

        assertEquals(solides.get(1), new Cube(5, Materiau.PLA));

        assertEquals(solides.get(2),new Pyramide(14, 14, Materiau.ABS));

        assertEquals(solides.get(3), new Cube(25, Materiau.PETG));

    }

    @Test
    public void testTrier() throws IOException {
        listeSolides.getSolides().add(solide1);
        listeSolides.getSolides().add(solide2);
        listeSolides.getSolides().add(solide2);
        listeSolides.getSolides().add(solide3);
        listeSolides.getSolides().add(solide4);

        listeSolides.trier();

        List<Solide> solides = listeSolides.getSolides();
        assertTrue(solides.get(0).calculerVolume() <= solides.get(1).calculerVolume());
    }

    @Test
    public void testExporterTousSTL() throws IOException {
        listeSolides.getSolides().add(solide1);
        listeSolides.getSolides().add(solide2);
        listeSolides.getSolides().add(solide2);
        listeSolides.getSolides().add(solide3);
        listeSolides.getSolides().add(solide4);

        String pathOut = System.getProperty("user.dir") + fSep + "src" + fSep + "donneesSTL" + fSep;
        File folder = new File(pathOut);

        listeSolides.exporterTousSTL(pathOut);

        File[] files = folder.listFiles();
        assertNotNull(files);
        assertTrue(files.length > 0);

    }

    @Test
    public void testConstructeurFileAttente() {
        assertTrue(fileAttente.estVide());
    }

    @Test
    public void testEstVideQuandVide() {
        assertTrue(fileAttente.estVide());
    }

    @Test
    public void testEstVideQuandNonVide() {
        fileAttente.ajouterSolide(solide1);
        assertFalse(fileAttente.estVide());
    }

    @Test
    public void testAjouterSolideCube() {
        Cube cube = new Cube(5.0, Materiau.NYLON);
        fileAttente.ajouterSolide(cube);

        assertFalse(fileAttente.estVide());
        assertEquals(cube, fileAttente.retirerSolide());
    }

    @Test
    public void testAjouterSolidePyramide() {
        Pyramide pyramide = new Pyramide(4.0, 6.0, Materiau.PLA);
        fileAttente.ajouterSolide(pyramide);

        assertFalse(fileAttente.estVide());
        assertEquals(pyramide, fileAttente.retirerSolide());
    }

    @Test
    public void testAjouterSolidesDansOrdre() {
        Cube cube1 = new Cube(5.0, Materiau.PLA);
        Cube cube2 = new Cube(3.0, Materiau.NYLON);
        Pyramide pyramide1 = new Pyramide(4.0, 6.0, Materiau.PLA);

        fileAttente.ajouterSolide(cube1);
        fileAttente.ajouterSolide(cube2);
        fileAttente.ajouterSolide(pyramide1);

        // Vérifier que les solides sont triés par volume croissant
        assertEquals(cube2, fileAttente.retirerSolide());
        assertEquals(pyramide1, fileAttente.retirerSolide());
        assertEquals(cube1, fileAttente.retirerSolide());
    }

    @Test
    public void testRetirerSolideQuandVide() {
        assertNull(fileAttente.retirerSolide(), "Il ne devrait pas y avoir de solide à retirer, la file est vide.");
    }

    @Test
    public void testRetirerSolide() {
        Cube cube = new Cube(5.0, Materiau.NYLON);
        fileAttente.ajouterSolide(cube);

        // Retirer le solide
        Solide solideRetire = fileAttente.retirerSolide();
        assertEquals(cube, solideRetire);
    }
}