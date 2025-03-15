package solides;

/**
 * Enumération représentant les différents types de matériaux utilisés pour les solides.
 * Chaque matériau est associé à un nom qui peut être utilisé pour l'affichage ou la description.
 */
public enum Materiau {
    NYLON("NYLON"), PETG("PTEG"), PLA("PLA"), ABS("ABS");

    private final String nom;

    /**
     * Constructeur pour l'énumération Materiau.
     *
     * @param nom le nom du matériau
     */
    Materiau(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne le nom du matériau.
     *
     * @return le nom du matériau
     */
    public String getNom() {
        return nom;
    }
}