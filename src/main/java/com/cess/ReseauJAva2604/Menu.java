package com.cess.ReseauJAva2604;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	Scanner sc = new Scanner(System.in);
	private boolean afficherMenu = true;
	private boolean afficheFormNewUser = true;

	Utilisateur currentUser;
	int friend;
	int choix;
	/**
	 * connexion BDD
	 */

	/**
	 * 
	 * @param En
	 *            les mettant ici on aura pas besoin de les rappeler à chaque fois
	 *            comme param de fction comme un import
	 */
	Post post;
	Utilisateur user;
	Utilisateur mod;
	private UtilisateurDAO uDao = new UtilisateurDAO();

	/**
	 * 
	 * @param user
	 * @param mod
	 * @param post
	 */

	@SuppressWarnings("finally")
	public Menu(Utilisateur user, Moderateur mod, Post post) {

		sc = new Scanner(System.in);

		this.post = post;

		while (afficheFormNewUser) {
			try {

				System.out.println("\nWelcome to CessSpot \n");
				System.out.println("Choisissez votre niveau d'autorisation\n");
				System.out.println("utilisateur 0 / Admin 1 / super Admin 2");
				int level = sc.nextInt();
				sc.nextLine();

				switch (level)

				{

				case 0:
					this.currentUser = user;
					this.user = user;
					setUser();
					this.currentUser = uDao.create(user);

					break;

				case 1:
					this.currentUser = mod;
					this.mod = mod;
					setUser();
					this.currentUser = uDao.createMod(mod, level);

					break;
				case 2:
					this.currentUser = mod;
					this.mod = mod;
					setUser();
					this.currentUser = uDao.createMod(mod, level);

					break;
				}
				afficheFormNewUser = false;
			} catch (InputMismatchException e) {
				System.out.println("Vous n'avez pas tapé l'un des choix possibles!");
				// input.reset();
			} finally {
				/**
				 * continue permet de réexecuter la boucle si l'erreur est rencontrée ATTENTION
				 * ne fonctionne que dans le cadre d'une boucle
				 */
				continue;
			}
		}

		while (afficherMenu) {
			if (currentUser.isModerateur() == false) {

				menuU();
			}

			else if (currentUser.isModerateur() == true && ((Moderateur) currentUser).getModo() == 1)

			{

				menuM();
			}

			else if (currentUser.isModerateur() == true && ((Moderateur) currentUser).getModo() == 2)  {

				menuS();

			}

			afficherMenu = retour();

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

		do {
			System.out.println("Répondre par O / N");
			r = sc.nextLine().charAt(0);
		} while (r != 'O' && r != 'N');
		if (r == 'O') {
			return true;
		} else {
			Connexion.close();
			System.out.println("A bientôt sur CessSpot!!");
			return false;
		}
	}

	public void setUser() {

		System.out.println("Entrez votre nom");
		String nom = sc.nextLine();
		currentUser.setNom(nom);
		System.out.println("Entrez votre prénom");
		String prenom = sc.nextLine();
		currentUser.setPrenom(prenom);
		System.out.println("Entrez votre pays de résidence");
		String pays = sc.nextLine();
		currentUser.setDateNaissance(pays);
		System.out.println("Entrez votre date de naissance");
		String dateNaissance = sc.nextLine();
		currentUser.setPays(dateNaissance);

	}

	private void addFriend() {
		/**
		 * show all affiche tous les users
		 */
		displayUsers();

		System.out.println("Entrez le numéro de la personne à ajouter en ami");
		this.friend = sc.nextInt();
		sc.nextLine();
		uDao.addOneFriend(currentUser, this.friend);
		/**
		 * find affiche les amis du current user
		 */
		displayFriends();
	}

	private void deleteFriend() {
		displayFriends();
		System.out.println("Entrez le numéro de l'ami à supprimer");
		int friendDeletion = sc.nextInt();
		sc.nextLine();
		uDao.deleteFriend(currentUser, friendDeletion);

	}

	private void read() {
		String[][] messages = this.post.getPost();
		/**
		 * la seconde condition permet de ne selectionner que les messages qui ont un
		 * auteur
		 */
		for (int i = 0; i < messages.length && messages[i][0] != null; i++) {

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

	private void displayUsers() {
		System.out.println("Liste de tous les utilisateurs :");
		ArrayList<Utilisateur> listeUsers = uDao.showAllUsers();

		/**
		 * on parcours l'array liste issue de la BDD (return de la fonction
		 * getallfriends)
		 */
		for (Utilisateur users : listeUsers) {
			System.out.println(users.getId() + " "+ users.getNom() + " " + users.getPrenom() + "\n");
		}
	}

	private void displayFriends() {
		// TODO Auto-generated method stub
		System.out.println("Liste de vos amis :");
		ArrayList<Utilisateur> listeAmis = uDao.getAllFriends(currentUser);
		

		/**
		 * on parcours l'array liste issue de la BDD (return de la fonction
		 * getallfriends)
		 */
		for (Utilisateur ami : listeAmis) {
			
			System.out.println(ami.getId()+" " +ami.getNom());
		}

	}

	private void showProfil() { // TODO EN COURS

		System.out.println(currentUser.getNom());
		System.out.println(currentUser.getPrenom());
		System.out.println(currentUser.getDateNaissance());
		System.out.println(currentUser.getPays());

	}

	private void deleteUser() {
		displayUsers();

		System.out.println("Entrez le numéro de l'utilisateur à supprimer");
		int userDeletion = sc.nextInt();
		sc.nextLine();
		uDao.delete(userDeletion);

	}

	private void deleteMessage() {
		read();

	}

	private void modifyMessage() {
		read();
		post.setpost();

	}

	private void exit() {

		System.out.println("Voulez vous vraiment quitter CessSpot ?");

	}

	/**
	 * Menu utilisateur simple
	 */

	private void menuU() {

		System.out.println("Que souhaitez vous faire aujourd'hui? (Tapez le chiffre correpondant)\n");

		System.out.println("1- Affichez votre profil");

		System.out.println("2- Ecrire un message");

		System.out.println("3- Afficher un message");

		System.out.println("4- Ajouter un ami");

		System.out.println("5- Afficher votre liste d'ami");

		System.out.println("6- Supprimer un ami");

		System.out.println("0- Quitter CessSpot");

		int choix = sc.nextInt();
		sc.nextLine();

		switch (choix)

		{

		case 1:

			showProfil();

			break;

		case 2:

			write();

			break;
		case 3:

			read();

			break;
		case 4:

			addFriend();

			break;
		case 5:

			displayFriends();

			break;
		case 6:

			deleteFriend();

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

		System.out.println("Que souhaitez vous faire aujourd'hui? (Tapez le chiffre correpondant)\n");

		System.out.println("1- Affichez votre profil");

		System.out.println("2- Ecrire un message");

		System.out.println("3- Afficher un message");

		System.out.println("4- Ajouter un ami");

		System.out.println("5- Afficher votre liste d'ami");
		System.out.println("6- Supprimer un ami");

		System.out.println("0- Quitter CessSpot\n");

		System.out.println("** ADMIN **");

		System.out.println("6- Supprimer Messages Autres Utilisateurs");

		System.out.println("7- Editer Messages Autres Utilisateurs");

		System.out.println("8- afficher les utilisateurs");

		int choix = sc.nextInt();
		sc.nextLine();

		switch (choix)

		{

		case 1:

			showProfil();

			break;

		case 2:

			write();

			break;
		case 3:

			read();

			break;
		case 4:

			addFriend();

			break;
		case 5:

			displayFriends();

			break;
		case 0:
			exit();

			break;
		case 6:
			deleteFriend();

			break;

		case 7:
			modifyMessage();

			break;
		case 8:
			displayUsers();

			break;
		
		}
	}

	/**
	 * Menu SuperModerateur
	 */
	private void menuS() {

		System.out.println("Que souhaitez vous faire aujourd'hui? (Tapez le chiffre correpondant)\n");

		System.out.println("1- Affichez votre profil");

		System.out.println("2- Ecrire un message");

		System.out.println("3- Afficher un message");

		System.out.println("4- Ajouter un ami");

		System.out.println("5- Afficher votre liste d'ami");
		System.out.println("10- Supprimer un ami");
		System.out.println("0- Quitter CessSpot\n");

		// System.out.println("9- Créer un compte");

		System.out.println("** ADMIN **");

		System.out.println("6- Supprimer Messages Autres Utilisateurs");

		System.out.println("7- Editer Messages Autres Utilisateurs");

		System.out.println("8- afficher les utilisateurs");

		System.out.println("9- Supprimer un utilisateur");

		int choix = sc.nextInt();
		sc.nextLine();
		// System.out.println("Bienvenue sur CessSpot "+ prenom +" "+nom);

		switch (choix)

		{

		case 1:

			showProfil();

			break;

		case 2:

			write();

			break;
		case 3:

			read();

			break;
		case 4:

			addFriend();

			break;
		case 5:

			displayFriends();

			break;
		case 0:
			exit();

			break;

		case 6:
			deleteMessage();

			break;
		case 7:
			modifyMessage();

			break;
		case 8:
			displayUsers();

			break;
		case 9:
			deleteUser();

			break;
		case 10:
			deleteFriend();
			break;

		}

	}
}
