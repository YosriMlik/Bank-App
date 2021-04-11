import java.util.Scanner;

public class Client {

    String nom;
    String prenom;
    int UserID;

    int nbCompte = 0;
    public Compte[] comptes = new Compte[100];

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getUserID() {
        return UserID;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public void ajouterCompte() {
        nbCompte++;
        comptes[nbCompte - 1] = new Compte(nbCompte);
    }

    public void AfficherPersonne() {
        System.out.println("Nom : " + nom + "\nPrenom : " + prenom);
        System.out.println("Posséde " + nbCompte + " copmtes");
    }

    public void afficherbilan() {
        if (nbCompte == 0) {
            System.out.println("Son bilan est vide !!");
        } else {
            System.out.println("Son bilan est : ");
            for (int i = 0; i < nbCompte; i++) {
                System.out.println("Le solde du compte " + (i + 1) + " est " + comptes[i].getSolde());
            }
        }
    }

    public Client(int id, String n, String p) {
        UserID = id;
        nom = n;
        prenom = p;
    }

    public void interaction() {
        boolean fini = false;
        while (fini == false) {
            Scanner input = new Scanner(System.in);
            System.out.println("\n*********************** BONJOUR " + getNom().toUpperCase() + " " + getPrenom().toUpperCase() + " ***********************");
            System.out.println("Quelle opération voulez-vous effectuer \n 1) Faire dépot. \n 2) Faire un ratrait. \n 3) Faire un virment \n 4) Ajouter un compte \n 5) Afficher le bilan des comptes. \n 6) Revenir au menu principale. ");
            System.out.print("Votre choix : ");
            int x = input.nextInt();
            switch (x) {
                case 1:
                    System.out.println("");
                    if (nbCompte > 1) {
                        System.out.print("Entrer le numero du compte: ");
                        int n = input.nextInt();
                        System.out.print("Quel est le montant: ");
                        float m = input.nextFloat();
                        comptes[n - 1].depot(m);
                        System.out.println("Opération terminée");
                    } else {
                        System.out.print("Quel est le montant: ");
                        float m = input.nextFloat();
                        comptes[0].depot(m);
                        System.out.println("Opération terminée");
                    }
                    break;
                case 2:
                    System.out.println("");
                    if (nbCompte > 1) {
                        System.out.print("Entrer le numero du compte: ");
                        int n2 = input.nextInt();
                        System.out.print("Quel est le montant: ");
                        float mt = input.nextFloat();
                        if (comptes[n2 - 1].solde <= mt) {
                            System.out.println("Solde insiffusant !!");
                        } else {
                            comptes[n2 - 1].retrait(mt);
                            System.out.println("Opération terminée");
                        }
                    } else if (nbCompte == 1) {
                        System.out.print("Quel est le montant: ");
                        float mt = input.nextFloat();
                        if (comptes[0].solde <= mt) {
                            System.out.println("Solde insiffusant -_-");
                        } else {
                            comptes[0].retrait(mt);
                            System.out.println("Opération terminée");
                        }
                    } else {
                        System.out.println("Veuiller creé un compte !!");
                    }
                    break;
                case 3:
                    if (nbCompte < 1) {
                        System.out.println("Veuiller creé un compte !!");
                        this.interaction();
                    } else if (nbCompte == 1) {
                        System.out.println("");
                        System.out.print("Vers quel compte: ");
                        int nav = input.nextInt();
                        System.out.print("Quel est le montant: ");
                        float mv = input.nextFloat();
                        if (comptes[0].solde < mv) {
                            System.out.println("Solde insiffusant -_-");
                        } else {
                            comptes[0].virer(mv, comptes[nav - 1]);
                            System.out.println("Opération terminée");
                        }
                    } else if (nbCompte >= 1) {
                        System.out.print("Entrer le numero du compte: ");
                        int n3 = input.nextInt();
                        System.out.print("Vers quel compte: ");
                        int nav = input.nextInt();
                        System.out.print("Quel est le montant: ");
                        float mv = input.nextFloat();
                        if (comptes[n3 - 1].solde < mv) {
                            System.out.println("Solde insiffusant -_-");
                        } else {
                            comptes[n3 - 1].virer(mv, comptes[nav - 1]);
                            System.out.println("Opération terminée");
                        }
                    } else {
                        System.out.println("Veuiller creé un compte !!");
                        this.interaction();
                    }
                    break;
                case 4:
                    System.out.println("");
                    this.ajouterCompte();
                    System.out.println("Le compte numéro " + nbCompte + " de " + getNom() + " a été crée avec succés");
                    break;
                case 5:
                    System.out.println("");
                    this.afficherbilan();
                    break;
                case 6:
                    fini = true;
                    break;
                default:
                    System.out.println("Choisisser une opération à partir les numéros (1, 2, .. ,6) !!");
                    break;

            }
        }
    }
}
