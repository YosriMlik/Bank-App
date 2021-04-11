import java.util.Scanner;

public class BankInteractive {

    Client[] clients = new Client[100];
    int nbClient = 0;

    public void ajouterClient(String nomClient, String prenomClient) {
        nbClient++;
        clients[nbClient - 1] = new Client(nbClient, nomClient, prenomClient);
    }

    public void bilanClient(int numeroduclient) {
        clients[numeroduclient - 1].AfficherPersonne();
    }

    public void afficheBilan() {
        if (nbClient == 0) {
            System.out.println("Le Bilan est vide !!");
        }
        else {
            System.out.println("Bilan total du bank :");
            for (int i = 0; i < nbClient; i++) {
                System.out.println("");
                System.out.println("Client "+(i+1));
                clients[i].AfficherPersonne();
            }
        }
    }

    public void interaction() {
        boolean fini = false;
        while (fini != true) {
            System.out.println("=============================== BIENVENUE DANS NOTRE BANQUE <3 ===============================");
            System.out.println("Quelle operation voulez-vous effectuer ? \n 1) Ajouter un client \n 2) Afficher le bilan de la banque \n 3) Effectuer une operation sur un client \n 4) Quitter le programme");
            System.out.print("Votre choix : ");
            Scanner input = new Scanner(System.in);
            int x = input.nextInt();
            switch (x) {
                case 1:
                    System.out.println("");
                    System.out.print("Entrez le nom: ");
                    String nomC = input.next();
                    System.out.print("Entrez le prenom: ");
                    String prenomC = input.next();
                    ajouterClient(nomC, prenomC);
                    clients[nbClient - 1].ajouterCompte();
                    System.out.println("Le client a été ajoutée\nSon ID : " + nbClient);
                    break;
                case 2:
                    System.out.println("");
                    this.afficheBilan();
                    break;
                case 3:
                    if(nbClient >= 1){
                        System.out.println("");
                        System.out.print("Entrer le ID du client: ");
                        int numC = input.nextInt();
                        clients[numC - 1].interaction();
                    }
                    else{
                        System.out.println("Pas de clients -_-");
                        this.interaction();
                    }
                    break;
                case 4:
                    fini = true;
                    break;
                default:
                    System.out.println("Choisisser une opération à partir les numéros (1, 2, .. ,4) !!");
                    break;            
            }
        }
    }
}
