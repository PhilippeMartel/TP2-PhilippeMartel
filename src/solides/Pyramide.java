package solides;

/**
 * Représente une pyramide, qui est un type de solide.
 * Cette classe permet de calculer le volume, la surface et de formater la représentation STL de la pyramide.
 * La pyramide est définie par la longueur du côté de sa base, sa hauteur et le matériau utilisé.
 * La longueur du côté de la base et la hauteur sont validées pour être dans une plage de valeurs définie.
 */
public class Pyramide extends Solide {

    /**
     * La longueur par défaut du côté de la base de la pyramide.
     */
    protected static double COTE_BASE_DEFAUT = 5;

    /**
     * La hauteur par défaut de la pyramide.
     */
    protected static double Hauteur_DEFAUT = 10;

    /**
     * La longueur du côté de la base de la pyramide.
     */
    private double coteBase;

    /**
     * La hauteur de la pyramide.
     */
    private double hauteur;

    /**
     * Constructeur par défaut de la pyramide, initialisant la longueur du côté
     * de la base et la hauteur avec les valeurs par défaut et le matériau par défaut.
     */
    public Pyramide() {
        this(COTE_BASE_DEFAUT, Hauteur_DEFAUT, MATERIAU_DEFAUT);
    }

    /**
     * Constructeur de la pyramide avec des dimensions et un matériau spécifiés.
     *
     * @param coteBase la longueur du côté de la base de la pyramide
     * @param hauteur la hauteur de la pyramide
     * @param materiau le matériau de la pyramide
     */
    public Pyramide(double coteBase, double hauteur, Materiau materiau) {
        super(materiau);
        setCoteBase(coteBase);
        setHauteur(hauteur);
    }

    /**
     * Retourne la longueur du côté de la base de la pyramide.
     *
     * @return la longueur du côté de la base
     */
    public double getCoteBase() {
        return coteBase;
    }

    /**
     * Retourne la hauteur de la pyramide.
     *
     * @return la hauteur de la pyramide
     */
    public double getHauteur() {
        return hauteur;
    }

    /**
     * Définit la longueur du côté de la base de la pyramide.
     *
     * @param coteBase la nouvelle longueur du côté de la base
     * @throws IllegalArgumentException si la longueur n'est pas valide
     */
    public void setCoteBase(double coteBase) {
        if (validerDimension(coteBase)) {
            this.coteBase = coteBase;
        } else {
            throw new IllegalArgumentException("La longueur du côté de la base doit être valide.");
        }
    }

    /**
     * Définit la hauteur de la pyramide.
     *
     * @param hauteur la nouvelle hauteur de la pyramide
     * @throws IllegalArgumentException si la hauteur n'est pas valide
     */
    public void setHauteur(double hauteur) {
        if (validerDimension(hauteur)) {
            this.hauteur = hauteur;
        } else {
            throw new IllegalArgumentException("La hauteur doit être valide.");
        }
    }

    /**
     * Calcule l'aire de la face de la pyramide.
     *
     * @return l'aire de la face de la pyramide
     */
    private double aireFAce() {
        return ((hauteur * coteBase) / 2);
    }

    /**
     * Calcule l'aire de la base de la pyramide.
     *
     * @return l'aire de la base de la pyramide
     */
    private double aireBase() {
        return Math.pow(coteBase, 2);
    }

    /**
     * Calcule la surface totale de la pyramide.
     *
     * @return la surface totale de la pyramide
     */
    @Override
    public double calculerSurface() {
        return (aireBase() + (aireFAce() * 4));
    }

    /**
     * Calcule le volume de la pyramide.
     *
     * @return le volume de la pyramide
     */
    @Override
    public double calculerVolume() {
        return (aireBase() * hauteur) / 3;
    }

    /**
     * Formate la pyramide en une chaîne de caractères au format STL pour l'exportation.
     * Le format STL décrit la géométrie de la pyramide pour une impression 3D.
     *
     * @return La représentation STL de la pyramide.
     */
    public String formaterSTL(){
        double d = coteBase / 2;

        return "solid pyramide\n" +
                "  facet normal 1 0 0\n" +
                "    outer loop\n" +
                "      vertex 0 0 " + hauteur + "\n" +
                "      vertex " + d + " " + d + " 0\n" +
                "      vertex " + d + " " + -(d) + " 0\n" +
                "    endloop\n" +
                "  endfacet\n" +
                "\n" +
                "  facet normal -1 0 0\n" +
                "    outer loop\n" +
                "      vertex 0 0 " + hauteur + "\n" +
                "      vertex " + -(d) + " " + d + " 0\n" +
                "      vertex " + -(d) + " " + -(d) + " 0\n" +
                "    endloop\n" +
                "  endfacet\n" +
                "\n" +
                "  facet normal 0 1 0\n" +
                "    outer loop\n" +
                "      vertex 0 0 " + hauteur + "\n" +
                "      vertex " + d + " " + d + " 0\n" +
                "      vertex " + -(d) + " " + d + " 0\n" +
                "    endloop\n" +
                "  endfacet\n" +
                "\n" +
                "  facet normal 0 -1 0\n" +
                "    outer loop\n" +
                "      vertex 0 0 " + hauteur + "\n" +
                "      vertex " + d + " " + -(d) + " 0\n" +
                "      vertex " + -(d) + " " + -(d) + " 0\n" +
                "    endloop\n" +
                "  endfacet\n" +
                "\n" +
                "  facet normal 0 0 -1\n" +
                "    outer loop\n" +
                "      vertex " + d + " " + -(d) + " 0\n" +
                "      vertex 0 " + d + " " + d + " 0\n" +
                "      vertex " + -(d) + " " + -(d) + " 0\n" +
                "    endloop\n" +
                "  endfacet\n" +
                "  facet normal 0 0 -1\n" +
                "    outer loop\n" +
                "      vertex " + -(d) + " " + d + " 0\n" +
                "      vertex 0 " + d + " " + d + " 0\n" +
                "      vertex " + -(d) + " " + -(d) + " 0\n" +
                "    endloop\n" +
                "  endfacet\n";
    }
}
