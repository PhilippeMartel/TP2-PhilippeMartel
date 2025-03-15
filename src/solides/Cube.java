package solides;

/**
 * Représente un cube, qui est un type de solide.
 * Cette classe permet de calculer le volume, la surface et de formater la représentation STL du cube.
 * Le cube est défini par la longueur de son côté et le matériau utilisé.
 * La longueur du côté est validée pour être dans une plage de valeurs définie.
 */
public class Cube extends Solide {

    /**
     * La longueur par défaut du côté du cube.
     */
    protected static double COTE_DEFAUT = 5;

    /**
     * La longueur du côté du cube.
     */
    private double cote;

    /**
     * Constructeur par défaut du cube, initialisant la longueur du côté
     * avec la valeur par défaut et le matériau par défaut.
     */
    public Cube() {
        this(COTE_DEFAUT, MATERIAU_DEFAUT);
    }

    /**
     * Constructeur du cube avec des dimensions spécifiées.
     *
     * @param cote la longueur du côté du cube
     * @param materiau le matériau du cube
     */
    public Cube(double cote, Materiau materiau) {
        super(materiau);
        setCote(cote);
    }

    /**
     * Retourne la longueur du côté du cube.
     *
     * @return la longueur du côté
     */
    public double getCote() {
        return cote;
    }

    /**
     * Définit la longueur du côté du cube.
     *
     * @param cote la nouvelle longueur du côté
     * @throws IllegalArgumentException si la longueur n'est pas valide
     */
    public void setCote(double cote) {
        if (validerDimension(cote)) {
            this.cote = cote;
        } else {
            throw new IllegalArgumentException("La longueur du côté doit être valide.");
        }
    }

    /**
     * Calcule la surface totale du cube.
     *
     * @return la surface totale du cube
     */
    @Override
    public double calculerSurface() {
        return (Math.pow(cote, 2) * 6);
    }

    /**
     * Calcule le volume du cube.
     *
     * @return le volume du cube
     */
    @Override
    public double calculerVolume() {
        return Math.pow(cote, 3);
    }

    /**
     * Formate le cube en une chaîne de caractères au format STL pour l'exportation.
     * Le format STL décrit la géométrie du cube pour une impression 3D.
     *
     * @return La représentation STL du cube.
     */
    public String formaterSTL() {
        return "solid cube\n" +
                "  facet normal 0 0 1\n" +
                "    outer loop\n" +
                "      vertex 0 0 " + cote + "\n" +
                "      vertex " + cote + " 0 " + cote + "\n" +
                "      vertex 0 " + cote + " " + cote + "\n" +
                "    endloop\n" +
                "  endfacet\n" +
                "  facet normal 0 0 1\n" +
                "    outer loop\n" +
                "      vertex " + cote + " 0 " + cote + "\n" +
                "      vertex " + cote + " " + cote + " " + cote + "\n" +
                "      vertex 0 " + cote + " " + cote + "\n" +
                "    endloop\n" +
                "  endfacet\n" +
                "\n" +
                "  facet normal 0 0 -1\n" +
                "    outer loop\n" +
                "      vertex 0 0 0\n" +
                "      vertex 0 " + cote + " 0\n" +
                "      vertex " + cote + " 0 0\n" +
                "    endloop\n" +
                "  endfacet\n" +
                "  facet normal 0 0 -1\n" +
                "    outer loop\n" +
                "      vertex " + cote + " 0 0\n" +
                "      vertex 0 " + cote + " 0\n" +
                "      vertex " + cote + " " + cote + " 0\n" +
                "    endloop\n" +
                "  endfacet\n" +
                "\n" +
                "  facet normal 0 1 0\n" +
                "    outer loop\n" +
                "      vertex 0 " + cote + " 0\n" +
                "      vertex 0 " + cote + " " + cote + "\n" +
                "      vertex " + cote + " " + cote + " 0\n" +
                "    endloop\n" +
                "  endfacet\n" +
                "  facet normal 0 1 0\n" +
                "    outer loop\n" +
                "      vertex " + cote + " " + cote + " 0\n" +
                "      vertex 0 " + cote + " " + cote + "\n" +
                "      vertex " + cote + " " + cote + " " + cote + "\n" +
                "    endloop\n" +
                "  endfacet\n" +
                "\n" +
                "  facet normal 0 -1 0\n" +
                "    outer loop\n" +
                "      vertex 0 0 0\n" +
                "      vertex " + cote + " 0 0\n" +
                "      vertex 0 0 " + cote + "\n" +
                "    endloop\n" +
                "  endfacet\n" +
                "  facet normal 0 -1 0\n" +
                "    outer loop\n" +
                "      vertex " + cote + " 0 0\n" +
                "      vertex " + cote + " 0 " + cote + "\n" +
                "      vertex 0 0 " + cote + "\n" +
                "    endloop\n" +
                "  endfacet\n" +
                "\n" +
                "  facet normal 1 0 0\n" +
                "    outer loop\n" +
                "      vertex " + cote + " 0 0\n" +
                "      vertex " + cote + " " + cote + " 0\n" +
                "      vertex " + cote + " 0 " + cote + "\n" +
                "    endloop\n" +
                "  endfacet\n" +
                "  facet normal 1 0 0\n" +
                "    outer loop\n" +
                "      vertex " + cote + " 0 " + cote + "\n" +
                "      vertex " + cote + " " + cote + " 0\n" +
                "      vertex " + cote + " " + cote + " " + cote + "\n" +
                "    endloop\n" +
                "  endfacet\n" +
                "\n" +
                "  facet normal -1 0 0\n" +
                "    outer loop\n" +
                "      vertex 0 0 0\n" +
                "      vertex 0 0 " + cote + "\n" +
                "      vertex 0 " + cote + " 0\n" +
                "    endloop\n" +
                "  endfacet\n" +
                "  facet normal -1 0 0\n" +
                "    outer loop\n" +
                "      vertex 0 0 " + cote + "\n" +
                "      vertex 0 " + cote + " " + cote + "\n" +
                "      vertex 0 " + cote + " 0\n" +
                "    endloop\n" +
                "  endfacet\n" +
                "endsolid cube\n";
    }
}
