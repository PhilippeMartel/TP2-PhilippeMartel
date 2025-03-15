package interfaces;

/**
 * Interface représentant un objet qui peut être imprimé.
 * Cette interface définit une méthode pour formater la représentation de l'objet
 * au format STL, qui est utilisé pour l'impression 3D.
 */
public interface Imprimable {

    /**
     * Formate l'objet en une chaîne de caractères au format STL.
     *
     * @return la représentation STL de l'objet
     */
    public String formaterSTL();
}