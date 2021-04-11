public class Compte {

    int id;
    float solde;

    public void depot(float montantDepot) {
        solde = solde + montantDepot;
    }

    public void retrait(float montantRetrait) {
        solde = solde - montantRetrait;
    }

    public float getSolde() {
        return solde;
    }

    public int getID() {
        return id;
    }

    public void afficherSolde() {
        System.out.println("Solde : " + solde);
    }
    public void virer(float montantVirer, Compte compteC) {
        compteC.depot(montantVirer);
        this.retrait(montantVirer);
    }
    public Compte(int num) {
        id = num;
    }
}
