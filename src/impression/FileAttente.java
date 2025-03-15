package impression;

import solides.Solide;

/**
 * Classe représentant une file d'attente des solides, triés en fonction de leur grosseur (volume).
 * Implémentation manuelle avec une liste chaînée.
 */
public class FileAttente {

    /**
     * Classe interne représentant un noeud de la file.
     */
    private static class NoeudFile {
        Solide solide;
        NoeudFile suivant;

        NoeudFile(Solide solide) {
            this.solide = solide;
            this.suivant = null;
        }
    }

    private NoeudFile tete;

    /**
     * Crée une nouvelle file d'attente vide.
     */
    public FileAttente() {
        tete = new NoeudFile(null);
    }

    /**
     * Vérifie si la file d'attente est vide.
     *
     * @return true si la file d'attente est vide, sinon false.
     */
    public boolean estVide() {
        return tete.solide == null;
    }

    /**
     * Ajoute un solide à la file d'attente en maintenant l'ordre croissant du volume.
     *
     * @param solide Le solide à ajouter à la file d'attente.
     */
    public void ajouterSolide(Solide solide) {
        NoeudFile tete;
        NoeudFile teteP = null;
        tete = this.tete;
        while (tete.solide != null){
            if(tete.solide.compareTo(solide) == -1){
                NoeudFile file = new NoeudFile(solide);
                file.suivant = tete;
                if (teteP != null) {
                    teteP.suivant = file;
                }else{
                    this.tete = file;
                }

            }else{
                teteP = tete;
                tete = tete.suivant;
            }
        }
    }

    /**
     * Retire et retourne le solide en tête de la file d'attente.
     *
     * @return Le solide à imprimer, ou null si la file d'attente est vide.
     */
    public Solide retirerSolide() {
        Solide solideRetire = tete.solide;
        tete = tete.suivant;
        return solideRetire;
    }
}
