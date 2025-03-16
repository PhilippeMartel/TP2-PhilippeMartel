package solides;

import interfaces.Imprimable;

/**
 * Classe abstraite représentant un solide.
 * Cette classe implémente l'interface Imprimable et fournit des méthodes
 * pour gérer les propriétés des solides, telles que le matériau,
 * la validation des dimensions et le calcul du volume et de la surface.
 */
public abstract class Solide implements Imprimable {

    /**
     * Le matériau par défaut utilisé pour les solides.
     */
    protected static Materiau MATERIAU_DEFAUT = Materiau.NYLON;

    /**
     * La dimension maximale autorisée pour les solides.
     */
    protected static double DIM_MAX = 50;

    /**
     * La dimension minimale autorisée pour les solides.
     */
    protected static double DIM_MIN = 1;

    /**
     * Le matériau du solide.
     */
    protected Materiau materiau;

    /**
     * Constructeur par défaut du solide, initialisant le matériau avec la valeur par défaut.
     */
    public Solide() {
        this(MATERIAU_DEFAUT);
    }

    /**
     * Constructeur du solide avec un matériau spécifié.
     *
     * @param materiau le matériau du solide
     */
    public Solide(Materiau materiau) {
        setMateriau(materiau);
    }

    /**
     * Retourne le matériau du solide.
     *
     * @return le matériau du solide
     */
    public Materiau getMateriau() {
        return materiau;
    }

    /**
     * Définit le matériau du solide.
     *
     * @param materiau le nouveau matériau du solide
     * @throws IllegalArgumentException si le matériau n'est pas valide
     */
    public void setMateriau(Materiau materiau) {
        if (validerMateriau(materiau)) {
            this.materiau = materiau;
        } else {
            throw new IllegalArgumentException("Matériau invalide.");
        }
    }

    /**
     * Valide si le matériau spécifié est valide.
     *
     * @param materiau le matériau à valider
     * @return true si le matériau est valide, false sinon
     */
    public boolean validerMateriau(Materiau materiau) {
        for (Materiau couleurPossible : Materiau.values()) {
            if (couleurPossible == materiau) {
                return true;
            }
        }
        return false;
    }

    /**
     * Valide si la dimension spécifiée est dans les limites autorisées.
     *
     * @param dimension la dimension à valider
     * @return true si la dimension est valide, false sinon
     */
    public boolean validerDimension(double dimension) {
        return (dimension < DIM_MAX && dimension > DIM_MIN);
    }

    /**
     * Compare le volume de ce solide avec celui d'un autre solide.
     *
     * @param solide le solide à comparer
     * @return 0 si les volumes sont égaux, un nombre négatif si ce solide est plus petit,
     *         ou un nombre positif si ce solide est plus grand
     */
    public int compareTo(Solide solide) {
        if (this.calculerVolume() == solide.calculerVolume()) {
            return 0;
        } else if (this.calculerVolume() < solide.calculerVolume()) {
            return -1;
        } else {
            return 1;
        }
    }

    /**
     * Calcule le volume du solide.
     * Cette méthode doit être implémentée par les sous-classes.
     *
     * @return le volume du solide
     */
    public abstract double calculerVolume();

    /**
     * Calcule la surface du solide.
     * Cette méthode doit être implémentée par les sous-classes.
     *
     * @return la surface du solide
     */
    public abstract double calculerSurface();

    /**
     * Retourne une représentation sous forme de chaîne du solide, incluant son type et son volume.
     *
     * @return une chaîne décrivant le solide
     */
    @Override
    public String toString() {
        return getClass() + " (volume = " + calculerVolume() + ")";
    }
}