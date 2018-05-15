package com.cess.ReseauJAva2604;

//import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		/**
		 * @info On note que modo spécifie utilisateur et en récupère donc ses atributs
		 *       et méthodes (setnom, getnom...)
		 */
		/**
		 * @info on instancie un nouvel utilisateur
		 */
		
		Utilisateur user = new Utilisateur();
		/**
		 * @info on instancie un nouveau Modérateur (pour messages)
		 */
		Moderateur mod = new Moderateur();
		/**
		 * @info on instancie un nouveau post (pour messages)
		 */
		Post post = new Post();
		/**
		 * @info on instancie un nouveau Menu (pour messages)
		 */
		Menu menu = new Menu(user, mod, post);
		/**
		 * @info on exécute la fonction Menu() de la classe Menu
		 */
	//	menu.Menu(user, mod, post);

	}
	
}
/// Partie 2 sans tableau/////////////////////////////////

// App app = new App(); // On crée une nouvelle instance de App afin de ne plus
// etre en static
// initialisation de l'utilisateur
/*
 * Utilisateur user = new Utilisateur(); user.setNom("Maisonneuve");
 * user.setPrenom("Vincent"); user.setDateNaissance("26 juin 1978");
 * user.setPays("FRANCE");
 */
// System.out.println("Bonjour " +utilisateur.getNom()+"
// "+utilisateur.getPrenom()+" vous êtes né le
// "+utilisateur.getDateNaissance()+" vous habitez en "+utilisateur.getPays());

// utilisateurB.setNom("Voiron");
// utilisateurB.setPrenom("Arnaud");
// utilisateurB.setDateNaissance("?? novembre 1985");
// utilisateurB.setPays("FRANCE");
// System.out.println("Bonjour " +utilisateurB.getNom()+"
// "+utilisateurB.getPrenom()+" vous êtes né le
// "+utilisateurB.getDateNaissance()+" vous habitez en
// "+utilisateurB.getPays());

/*
 * Moderateur mod1 = new Moderateur(); mod1.setNom("Zou");
 * mod1.setPrenom("Zou"); mod1.setDateNaissance("inconnue");
 * mod1.setPays("FRANCE");
 * 
 * Moderateur mod2 = new Moderateur(); mod2.setNom("Ip");
 * mod2.setPrenom("Cess"); mod2.setDateNaissance("14 mai 1986");
 * mod2.setPays("FRANCE"); mod2.setModo(2);
 */

// PARTIE 1 TD/////////////////////////////
/*
 * création d'un tableau utilisateurs en dur etape 1TD String users[][] = { {
 * "Ip", "Cess", "cess@cess.com", "Canada", "14 mai 1986" }, { "NewHouse",
 * "Vincent", "new@house.com", "France", "26 juin 1978 " } };
 * 
 * 
 * // On crée une nouvelle instance de tableau users String users[][] = new
 * String[4][6]; int userId = -1; // on crée une varialbe qui correspond au 1er
 * [] du tableau users, on met moins // -1 pour que la création commence bel et
 * bien à l'index 0
 * 
 * String messages[][] = new String[10][3]; int msgId =-1;
 * 
 * String amis[][] = { { "Ip", "Cess", "cess@cess.com", "Canada", "14 mai 1986"
 * } };
 * 
 * public static void main(String[] args) { App app = new App(); // On crée une
 * nouvelle instance de App afin de ne plus etre en static Utilisateur
 * utilisateur= new Utilisateur(); }
 * 
 * public App() { Scanner sc = new Scanner(System.in);
 * 
 * System.out.println("\nWelcome to CessSpot \n");
 * 
 * boolean afficherMenu = true;
 * 
 * while (afficherMenu) {
 * 
 * System.out.
 * println("Que souhaitez vous faire aujourd'hui? (Tapez le chiffre correpondant)\n"
 * );
 * 
 * System.out.println("9- Créer un compte");
 * 
 * System.out.println("1- Affichez votre profil");
 * 
 * System.out.println("2- Modifier vos informations ");
 * 
 * System.out.println("3- Ecrire un message");
 * 
 * System.out.println("4- Afficher un message");
 * 
 * System.out.println("5- Ajouter un ami");
 * 
 * System.out.println("6- Afficher votre liste d'ami");
 * 
 * System.out.println("0- Quitter CessSpot");
 * 
 * int choix = sc.nextInt(); sc.nextLine();// après nextInt toujours mettre Next
 * line car "entrée" crée une string
 * 
 * // System.out.println("Bienvenue sur CessSpot "+ prenom +" "+nom);
 * 
 * switch (choix)
 * 
 * {
 * 
 * case 1:
 * 
 * showProfil();
 * 
 * break;
 * 
 * case 2:
 * 
 * modifierProfil();
 * 
 * break; case 3:
 * 
 * write();
 * 
 * break; case 4:
 * 
 * read();
 * 
 * break; case 5:
 * 
 * addFriend();
 * 
 * break; case 6:
 * 
 * displayFriend();
 * 
 * break; case 0: exit();
 * 
 * break;
 * 
 * case 9:
 * 
 * newUser();
 * 
 * }
 * 
 * afficherMenu = retour();
 * 
 * } // fin while
 * 
 * }
 * 
 * private void newUser() { Scanner sc = new Scanner(System.in); //on déclare
 * les variables que l'on va récupérer avec la saisie clavier et utiliser dans
 * le tableau String nom,prenom, pays, dateNaiss;
 * 
 * // à chaque execution de la méthode, on incrémente le compteur userId
 * userId++;
 * 
 * System.out.println("Quel est votre nom ?"); nom=sc.nextLine();
 * users[userId][0]=nom; //le champ prend la valeur de la varialbe nom remplie
 * par l'utilisateur
 * 
 * System.out.println("Quel est votre prénom ?"); prenom=sc.nextLine();
 * users[userId][1]=prenom;
 * 
 * System.out.println("Quel est votre pays de résidence ?"); pays=sc.nextLine();
 * users[userId][2]=pays;
 * 
 * System.out.println("Quel est votre date de naissance ?");
 * dateNaiss=sc.nextLine(); users[userId][3]=dateNaiss;
 * 
 * 
 * 
 * }
 * 
 * private void displayFriend() { // TODO Auto-generated method stub
 * System.out.println("Amis de " + users[1][1]); System.out.println( amis[0][1]
 * + " " + amis[0][0] + " pays de résidence : " + amis[0][3] + " est né(e) le "
 * + amis[0][4]);
 * 
 * }
 * 
 * private void addFriend() { // TODO Auto-generated method stub
 * 
 * }
 * 
 * private void read() { // TODO Auto-generated method stub
 * System.out.println("Message de : " + messages[msgId][0]);
 * System.out.println("Titre : " + " " + messages[0][1]);
 * System.out.println("Message :" + " " + messages[0][2]);
 * 
 * }
 * 
 * private void write() { Scanner sc = new Scanner(System.in); //on déclare les
 * variables que l'on va récupérer avec la saisie clavier et utiliser dans le
 * tableau String auteur,body, titre;
 * 
 * // à chaque execution de la méthode, on incrémente le compteur userId
 * msgId++;
 * 
 * System.out.println("Auteur du message"); auteur=sc.nextLine();
 * messages[msgId][0]=auteur; //le champ prend la valeur de la varialbe nom
 * remplie par l'utilisateur
 * 
 * System.out.println("Titre du message"); titre=sc.nextLine();
 * messages[msgId][1]=titre;
 * 
 * System.out.println("Contenu du message"); body=sc.nextLine();
 * messages[msgId][2]=body;
 * 
 * 
 * 
 * }
 * 
 * private void modifierProfil() { // TODO Auto-generated method stub
 * 
 * }
 * 
 * private void showProfil() { // TODO Auto-generated method stub
 * 
 * System.out.println("Profil de " + users[0][0] + " " + users[0][1]);
 * System.out.println("Né(e) le" + " " + users[0][3]);
 * System.out.println("Pays de Résidence" + " " + users[0][2]);
 * 
 * }
 * 
 * private void exit() { // TODO Auto-generated method stub4
 * System.out.println("A bientôt sur CessSpot!!"); }
 * 
 * // fonction permettant de retourner au menu : /** Demande a l'utilisateur si
 * il faut returner au menu ou quiter
 * 
 * @return : true si on retourne au menu sinon false
 * 
 * public boolean retour() { System.out.println("Retourner au menu ? "); return
 * demanderOuiNon();
 * 
 * }
 * 
 * private boolean demanderOuiNon() { char r; Scanner ret = new
 * Scanner(System.in); do { System.out.println("Répondre par O / N"); r =
 * ret.nextLine().charAt(0); } while (r != 'O' && r != 'N'); if (r == 'O') {
 * return true; } else { return false; } }
 */
