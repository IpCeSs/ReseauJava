package com.cess.ReseauJAva2604;

import java.util.Scanner;

public class Menu {

	private boolean afficherMenu = true;

	/**
	 * 
	 * @param utilisateur
	 */

	public void Menu(Moderateur modo2, Post post) {

		Scanner sc = new Scanner(System.in);
		System.out.println("\nWelcome to CessSpot \n");
		if (modo2.isModerateur() == false) {
			while (afficherMenu) {

				System.out.println("Que souhaitez vous faire aujourd'hui? (Tapez le chiffre correpondant)\n");

				System.out.println("1- Affichez votre profil");

				System.out.println("2- Modifier vos informations ");

				System.out.println("3- Ecrire un message");

				System.out.println("4- Afficher un message");

				System.out.println("5- Ajouter un ami");

				System.out.println("6- Afficher votre liste d'ami");

				System.out.println("9- Créer un compte");

				System.out.println("0- Quitter CessSpot");

				int choix = sc.nextInt();
				sc.nextLine();
				// System.out.println("Bienvenue sur CessSpot "+ prenom +" "+nom);

				switch (choix)

				{

				case 1:

					showProfil(modo2);

					break;

				case 2:

					modifierProfil(modo2);

					break;
				case 3:

					write(post);

					break;
				case 4:

					read(post);

					break;
				case 5:

					addFriend();

					break;
				case 6:

					displayFriend();

					break;
				case 0:
					exit();

					break;

				case 9:

					newUser();

					break;

				}

				afficherMenu = retour();

			} // fin while
		} // fin if
		else if (modo2.isModerateur() == true && Moderateur.getModo() == 1) {
			while (afficherMenu) {

				System.out.println("Que souhaitez vous faire aujourd'hui? (Tapez le chiffre correpondant)\n");
// pour les invités qui n'ont pas soif
				System.out.println("1- Affichez votre profil");

				System.out.println("2- Modifier vos informations ");

				System.out.println("3- Ecrire un message");

				System.out.println("4- Afficher un message");

				System.out.println("5- Ajouter un ami");

				System.out.println("6- Afficher votre liste d'ami");

				System.out.println("9- Créer un compte");

				System.out.println("10- Supprimer Messages Autres Utilisateurs");

				System.out.println("11- Editer Messages Autres Utilisateurs");

				System.out.println("12- afficher les utilisateurs");

				System.out.println("0- Quitter CessSpot");

				int choix = sc.nextInt();
				sc.nextLine();
				// System.out.println("Bienvenue sur CessSpot "+ prenom +" "+nom);

				switch (choix)

				{

				case 1:

					showProfil(modo2);

					break;

				case 2:

					modifierProfil(modo2);

					break;
				case 3:

					write(post);

					break;
				case 4:

					read(post);

					break;
				case 5:

					addFriend();

					break;
				case 6:

					displayFriend();

					break;
				case 0:
					exit();

					break;

				case 9:

					newUser();
				case 10:
					delUsersMessages();

					break;
				case 11:
					editUsersMessages();

					break;
				case 12:
					allUsers();

					break;

				}

				afficherMenu = retour();

			}
		} // fin else if
		else {
			while (afficherMenu) {

				System.out.println("Que souhaitez vous faire aujourd'hui? (Tapez le chiffre correpondant)\n");

				System.out.println("1- Affichez votre profil");

				System.out.println("2- Modifier vos informations ");

				System.out.println("3- Ecrire un message");

				System.out.println("4- Afficher un message");

				System.out.println("5- Ajouter un ami");

				System.out.println("6- Afficher votre liste d'ami");

				System.out.println("9- Créer un compte");

				System.out.println("10- Supprimer Messages Autres Utilisateurs");

				System.out.println("11- Editer Messages Autres Utilisateurs");

				System.out.println("12- afficher les utilisateurs");

				System.out.println("13- Supprimer un utilisateur");

				System.out.println("0- Quitter CessSpot");

				int choix = sc.nextInt();
				sc.nextLine();
				// System.out.println("Bienvenue sur CessSpot "+ prenom +" "+nom);

				switch (choix)

				{

				case 1:

					showProfil(modo2);

					break;

				case 2:

					modifierProfil(modo2);

					break;
				case 3:

					write(post);

					break;
				case 4:

					read(post);

					break;
				case 5:

					addFriend();

					break;
				case 6:

					displayFriend();

					break;
				case 0:
					exit();

					break;

				case 9:

					newUser();
				case 10:
					delUsersMessages();

					break;
				case 11:
					editUsersMessages();

					break;
				case 12:
					allUsers();

					break;
				case 13:
					deleteUser();

					break;
					

				}

				afficherMenu = retour();

			}
		}

	}
	/*
	 * @return : true si on retourne au menu sinon false
	 */

	private void editUsersMessages() {
		// TODO Auto-generated method stub

	}

	private void delUsersMessages() {
		// TODO Auto-generated method stub

	}

	private void allUsers() {
		// TODO Auto-generated method stub

	}

	public boolean retour() {
		System.out.println("Retourner au menu ? ");
		return demanderOuiNon();

	}

	private boolean demanderOuiNon() {
		char r;
		Scanner ret = new Scanner(System.in);
		do {
			System.out.println("Répondre par O / N");
			r = ret.nextLine().charAt(0);
		} while (r != 'O' && r != 'N');
		if (r == 'O') {
			return true;
		} else {
			return false;
		}
	}

	private void newUser() {
		Scanner sc = new Scanner(System.in);

		// à chaque execution de la méthode, on incrémente le compteur userId
		// userId++;

		// System.out.println("Quel est votre nom ?"); nom=sc.nextLine();
		// users[userId][0]=nom;

		// System.out.println("Quel est votre prénom ?"); prenom=sc.nextLine();
		// users[userId][1]=prenom;

		// System.out.println("Quel est votre pays de résidence ?"); pays=sc.nextLine();
		// users[userId][2]=pays;

		System.out.println("Quel est votre date de naissance ?");
		// dateNaiss=sc.nextLine(); users[userId][3]=dateNaiss;

	}

	private void displayFriend() { // TODO Auto-generated method stub
		// System.out.println("Amis de " + users[1][1]); System.out.println( amis[0][1]
		// + " " + amis[0][0] + " pays de résidence : " + amis[0][3] + " est né(e) le "
		// + amis[0][4]);

	}

	private void addFriend() { // TODO Auto-generated method stub

	}

	/**
	 * 
	 * @param messages
	 */

	private void read(Post post) {
		//for(int i=post.getMsgId();i<9;i++) {
		System.out.println("Auteur   " + post.getAuteur());
		System.out.println("Titre   " + post.getTitre());
		System.out.println("Message   " + post.getBody()+"\n");
		//}
	}

	private void write(Post post) {

		Scanner sc = new Scanner(System.in);
		/**
		 * on déclare les variables que l'on va récupérer avec la saisie clavier et
		 * utiliser dans le tableau String auteur,body, titre;
		 */

		// à chaque execution de la méthode, on incrémente le compteur userId
		int id = post.getMsgId();

		System.out.println("Auteur du message");

		post.setAuteur(sc.nextLine());

		System.out.println("Titre du message");

		post.setTitre(sc.nextLine());

		System.out.println("Contenu du message");

		post.setBody(sc.nextLine());
		;
		id++;

	}

	/**
	 * 
	 * @param utilisateur
	 * 
	 *            pour modifier une donnée de utilisateur
	 */

	private void modifierProfil(Moderateur modo2) { // TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("entrez votre nouveau nom");
		modo2.setNom(sc.nextLine());
		System.out.println("entrez votre nouveau prenom");
		modo2.setPrenom(sc.nextLine());
		System.out.println("entrez votre nouveau pays de résidence");
		modo2.setPays(sc.nextLine());
		System.out.println("entrez votre nouvelle de de naissance");
		modo2.setDateNaissance(sc.nextLine());
		System.out.println("Vos Données on été modifiées " + modo2.getNom() + " " + modo2.getPrenom() + " "
				+ modo2.getDateNaissance() + " " + modo2.getPays());
	}

	/**
	 * 
	 * @param utilisateur
	 */

	private void showProfil(Moderateur modo2) { // TODO Auto-generated method stub

		System.out.println("Profil de " + modo2.getPrenom() + " " + modo2.getNom());
		System.out.println("Né(e) le" + " " + modo2.getDateNaissance());
		System.out.println("Pays de Résidence" + " " + modo2.getPays());

	}

	private void moderateur() {
		modifyMessage();
		deleteMessage();

	}

	private void superModerateur() {
		modifyMessage();
		deleteMessage();
		deleteUser();

	}

	private void deleteUser() {
		// TODO Auto-generated method stub

	}

	private void deleteMessage() {
		// TODO Auto-generated method stub

	}

	private void modifyMessage() {
		// TODO Auto-generated method stub

	}

	private void exit() { // TODO Auto-generated method stub4
		System.out.println("A bientôt sur CessSpot!!");
	}

}