package solides;

public enum Materiau {
    NYLON("NYLON"), PETG("PTEG"), PLA("PLA"), ABS("ABS");

    private final String nom;

    Materiau(String nom){
        this.nom = nom;
    }
}
