package solides;

import interfaces.Imprimable;
import jdk.jshell.UnresolvedReferenceException;

public abstract class Solide implements Imprimable {
    protected static Materiau MATERIAU_DEFAUT = Materiau.NYLON;
    protected static double DIM_MAX = 50;
    protected static double DIM_MIN = 1;
    protected Materiau materiau;

    public Solide() {
        this(MATERIAU_DEFAUT);
    }

    public Solide(Materiau materiau) {
        setMateriau(materiau);
    }

    public Materiau getMateriau(){
        return materiau;
    }

    public void setMateriau(Materiau materiau){
        if(validerMateriau(materiau)){
            this.materiau = materiau;
        }else{
            throw new IllegalArgumentException();
        }
    }


    public boolean validerMateriau(Materiau materiau){
        boolean invalide = false;

        for (Materiau couleurPossible : Materiau.values()) {
            if (couleurPossible == materiau) {
                invalide = true;
            }
        }

        return (invalide);
    }

    public boolean validerDimension(double dimension){
        return (dimension < DIM_MAX && dimension > DIM_MIN);
    }

    public int compareTo(Solide solide){
        if(this.calculerVolume() == solide.calculerVolume()){
            return 0;
        } else if (this.calculerVolume() < solide.calculerVolume()) {
            return -1;
        }else{
            return 1;
        }
    }

    public abstract double calculerVolume();

    public abstract double calculerSurface();

    @Override
    public String toString(){
        return getClass() + " (volume = " + calculerVolume() + ")";
    }


}
