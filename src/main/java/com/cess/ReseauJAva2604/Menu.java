package com.cess.ReseauJAva2604;

import java.util.Scanner;

public class Menu {

	private boolean afficherMenu = true;

	/**
	 * 
	 * @param En
	 *            les mettant ici on aura pas besoin de les rappeler à chaque fois
	 *            comme param de fction comme un import
	 */
	Post post;
	Utilisateur user;
	Moderateur mod;

	public void Menu(Utilisateur user, Moderateur mod, Post post) {

		this.post = post;

		Scanner sc = new Scanner(System.in);
		System.out.println("\nWelcome to CessSpot \n");
		System.out.println("Choisissez votre niveau d'autorisation\n");
		System.out.println("utilisateur 0 / Admin 1 / super Admin");
		int level = sc.nextInt();
		sc.nextLine();

		Utilisateur currentUser = null;

		switch (level)

		{

		case 0:
			currentUser = user;
			user.setUser();

			break;

		default:
			currentUser = mod;
			mod.setModo(level);

			break;

		}

		while (afficherMenu) {
			if (currentUser.isModerateur() == false) {

				menuU();
			}

			else if (currentUser.isModerateur() == true && ((Moderateur) currentUser).getModo() == 1)

			{

				menuM();
			}

			else {

				menuS();

			}

			afficherMenu = retour();

		}
	}

	private void allUsers() {
		String[][] users = this.user.getUsers();
		for (int i = 0; i < users.length; i++) {
			System.out.println("Nom :  " + users[i][0]);
			System.out.println("Prénom :  " + users[i][1]);
			System.out.println("Pays de résidence :   " + users[i][2]);
			System.out.println("Né(e) le :   " + users[i][3] + "\n");
		}

	}

	public boolean retour() {
		System.out.println("Retourner au menu ? ");
		return demanderOuiNon();

	}

	/**
	 * 
	 * @return true si O false si N (la question est posée si les caractères saisis
	 *         ne sont ni O ni N
	 */
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

	private void read() {
		String[][] messages = this.post.getPost();
		for (int i = 0; i < messages.length; i++) {
			System.out.println("Auteur   " + messages[i][0]);
			System.out.println("Titre   " + messages[i][1]);
			System.out.println("Message   " + messages[i][2] + "\n");
		}
	}

	private void write() {

		/**
		 * on appelle la fonction setPost de la classe post
		 */
		post.setpost();

	}

	/**
	 * 
	 * @param utilisateur
	 *            pour modifier les données de utilisateur
	 */

	private void modifierProfil() { // TODO Auto-generated method stub
	////////	ENCOURS
	/**	user.setUser();
		user.getUsers();
		System.out.println("Nom :  " + user[userId][0]);
		System.out.println("Prénom :  " + user[userId][1]);
		System.out.println("Pays de résidence :   " + users[userId][2]);
		System.out.println("Né(e) le :   " + user[userId][3] + "\n");*/
	}

	/**
	 * 
	 * @param utilisateur
	 */

	private void showProfil() { // TODO EN COURS 
		/*System.out.println("Profil de " + mod.getPrenom() + " " + mod.getNom());
		System.out.println("Né(e) le" + " " + mod.getDateNaissance());
		System.out.println("Pays de Résidence" + " " + mod.getPays());*/

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
		read();

	}

	private void modifyMessage() {
		read();
		post.setpost();

	}

	private void exit() {
		System.out.println("A bientôt sur CessSpot!!");
	}

	/**
	 * Menu utilisateur simple
	 */

	private void menuU() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Que souhaitez vous faire aujourd'hui? (Tapez le chiffre correpondant)\n");

		System.out.println("1- Affichez votre profil");

		System.out.println("2- Modifier vos informations ");

		System.out.println("3- Ecrire un message");

		System.out.println("4- Afficher un message");

		System.out.println("5- Ajouter un ami");

		System.out.println("6- Afficher votre liste d'ami");

		System.out.println("0- Quitter CessSpot");

		int choix = sc.nextInt();
		sc.nextLine();

		switch (choix)

		{

		case 1:

			showProfil();

			break;

		case 2:

			modifierProfil();

			break;
		case 3:

			write();

			break;
		case 4:

			read();

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

		}
	}

	/**
	 * Menu moderateur level 1
	 */

	private void menuM() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Que souhaitez vous faire aujourd'hui? (Tapez le chiffre correpondant)\n");

		System.out.println("1- Affichez votre profil");

		System.out.println("2- Modifier vos informations ");

		System.out.println("3- Ecrire un message");

		System.out.println("4- Afficher un message");

		System.out.println("5- Ajouter un ami");

		System.out.println("6- Afficher votre liste d'ami");

		System.out.println("0- Quitter CessSpot\n");

		System.out.println("** ADMIN **");

		System.out.println("7- Supprimer Messages Autres Utilisateurs");

		System.out.println("8- Editer Messages Autres Utilisateurs");

		System.out.println("9- afficher les utilisateurs");

		int choix = sc.nextInt();
		sc.nextLine();

		switch (choix)

		{

		case 1:

			showProfil();

			break;

		case 2:

			modifierProfil();

			break;
		case 3:

			write();

			break;
		case 4:

			read();

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
		case 7:
			deleteMessage();

			break;

		case 8:
			modifyMessage();

			break;
		case 9:
			allUsers();

			break;

		}

		afficherMenu = retour();

	}

	/**
	 * Menu SuperModerateur
	 */
	private void menuS() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Que souhaitez vous faire aujourd'hui? (Tapez le chiffre correpondant)\n");

		System.out.println("1- Affichez votre profil");

		System.out.println("2- Modifier vos informations ");

		System.out.println("3- Ecrire un message");

		System.out.println("4- Afficher un message");

		System.out.println("5- Ajouter un ami");

		System.out.println("6- Afficher votre liste d'ami");
		System.out.println("0- Quitter CessSpot\n");

		// System.out.println("9- Créer un compte");

		System.out.println("** ADMIN **");

		System.out.println("7- Supprimer Messages Autres Utilisateurs");

		System.out.println("8- Editer Messages Autres Utilisateurs");

		System.out.println("9- afficher les utilisateurs");

		System.out.println("10- Supprimer un utilisateur");

		int choix = sc.nextInt();
		sc.nextLine();
		// System.out.println("Bienvenue sur CessSpot "+ prenom +" "+nom);

		switch (choix)

		{

		case 1:

			showProfil();

			break;

		case 2:

			modifierProfil();

			break;
		case 3:

			write();

			break;
		case 4:

			read();

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

		case 7:
			deleteMessage();

			break;
		case 8:
			modifyMessage();

			break;
		case 9:
			allUsers();

			break;
		case 10:
			deleteUser();

			break;

		}
	}
}
