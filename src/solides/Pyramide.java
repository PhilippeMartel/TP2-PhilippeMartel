package solides;

public class Pyramide extends Solide{

    protected static double COTE_BASE_DEFAUT = 5;
    protected static double Hauteur_DEFAUT = 10;
    private double coteBase;
    private double hauteur;

    public Pyramide(){
        this(COTE_BASE_DEFAUT, Hauteur_DEFAUT, MATERIAU_DEFAUT);
    }

    public Pyramide(double coteBase, double hauteur, Materiau materiau){
        super(materiau);

    }

    public double getCoteBase() {
        return coteBase;
    }

    public double getHauteur() {
        return hauteur;
    }

    public void setCoteBase(double coteBase) {
        if (validerDimension(coteBase)){
            this.coteBase = coteBase;
        }else{
            throw new IllegalArgumentException();
        }
    }

    public void setHauteur(double hauteur) {
        if (validerDimension(hauteur)){
            this.hauteur = hauteur;
        }else{
            throw new IllegalArgumentException();
        }
    }

    private double aireFAce(){
        return ((hauteur * coteBase) / 2);
    }

    private double aireBase(){
        return Math.pow(coteBase, 2);
    }

    @Override
    public double calculerSurface() {
        return (aireBase() + (aireFAce() * 4));
    }

    @Override
    public double calculerVolume() {
        return 0;
    }

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
