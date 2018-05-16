package com.cess.ReseauJAva2604;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	private boolean afficherMenu = true;
	private boolean afficheFormNewUser = true;
	ArrayList<String> amis;
	Scanner sc;
	Utilisateur currentUser;
	int friend;

	/**
	 * connexion BDD
	 */
	String url = "jdbc:mysql://localhost/java";
	String login = "root";
	String passwd = "";
	Connection cn = null;
	Statement st = null;
	ResultSet rs = null;

	/**
	 * 
	 * @param En
	 *            les mettant ici on aura pas besoin de les rappeler à chaque fois
	 *            comme param de fction comme un import
	 */
	Post post;
	Utilisateur user;
	Moderateur mod;

	/**
	 * 
	 * @param user
	 * @param mod
	 * @param post
	 */

	@SuppressWarnings("finally")
	public Menu(Utilisateur user, Moderateur mod, Post post) {

		/**
		 * On peuple l'arrayList amis déclarée au dessus
		 */
		amis = new ArrayList();
		amis.add("Jean");
		amis.add("Bon");
		amis.add("Beurre");

		sc = new Scanner(System.in);

		this.post = post;

		while (afficheFormNewUser) {
			try {
				Scanner sc = new Scanner(System.in);
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
					user.setUser();

					break;

				default:
					this.currentUser = mod;
					this.mod = mod;
					mod.setModo(level);

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

			else {

				menuS();

			}

			afficherMenu = retour();

		}
	}

	private void allUsers() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "SELECT * FROM user";
			rs = st.executeQuery(sql);
			/**
			 * on parcours le result set rs NB : on est obligé de faire une ligne pour
			 * chaque colonne du tableau
			 */
			while (rs.next()) {
				System.out.println(rs.getInt("id") + " " + rs.getString("nom") + " " + rs.getString("prenom"));

				// System.out.println(rs.getString("dateNaissance") + ' ' +
				// rs.getString("pays"));

				System.out.println("\n");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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

	/**
	 * ne marche pas display friend
	 */
	private void displayFriend() {
		System.out.println("Liste de vos amis :");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			// st = cn.createStatement();
			/**
			 * On specifie amigo qui correspond à l'user ami pour dire que ce sont ses
			 * données à lui que l'on veut et non celles du current user
			 */
			String sql = "SELECT amigo.nom, amigo.prenom FROM user current JOIN ami a ON a.user_id=current.id JOIN user amigo ON amigo.id=a.friend_id WHERE current.id =?";

			PreparedStatement pstat = cn.prepareStatement(sql);
			/**
			 * on set une valeur pour le ? si on avait plusieurs point d'interogations, on
			 * accederai au prenmier avec 1 au second avec 2 etc
			 */
			pstat.setInt(1, currentUser.getId());
			rs = pstat.executeQuery();

			/**
			 * on parcours le result set rs NB : on est obligé de faire une ligne pour
			 * chaque colonne du tableau
			 */
			while (rs.next()) {

				System.out.println(rs.getString("nom") + " " + rs.getString("prenom"));

				// System.out.println(rs.getString("dateNaissance") + ' ' +
				// rs.getString("pays"));

				// System.out.println("\n");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		/**
		 * ARRAY lIST for (int i = 0; i < amis.size(); i++) {
		 * System.out.println(amis.get(i)); }
		 */

	}

	private void addFriend() { // TODO Auto-generated method stub
		allUsers();

		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez le numéro correspondant à votre");
		this.friend = sc.nextInt();
		sc.nextLine();

		try {
			/**
			 * Chargement du driver
			 */
			Class.forName("com.mysql.jdbc.Driver");
			/**
			 * récupération de la connexion
			 */
			cn = DriverManager.getConnection(url, login, passwd);
			/**
			 * Création d'un statement
			 */
			st = cn.createStatement();
			String sql = "INSERT INTO `ami` (`user_id`,`friend_id`) VALUES (" + currentUser.getId() + ",'" + this.friend
					+ "')";
			/**
			 * exercution requete
			 */
			st.executeUpdate(sql);
			displayFriend();
		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				/**
				 * libérer ressource memoire, fermeture connection
				 */
				cn.close();
				st.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		/**
		 * System.out.println("Saisissez le nom de votre ami"); String addAmi =
		 * sc.nextLine(); amis.add(addAmi); System.out.println("Ami ajouté avec
		 * succès!");
		 */

	}

	private void deleteFriend() {
		displayFriend();

		System.out.println("Saisissez le nom de votre ami");
		String supAmi = sc.nextLine();
		if (amis.contains(supAmi)) {
			amis.remove(supAmi);
			System.out.println("Ami supprimé avec succès!");
		} else {
			System.out.println("Erreur de saisie, cet ami n'existe pas!");
		}

	}

	/**
	 * 
	 * @param messages
	 */

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

	/**
	 * 
	 * @param utilisateur
	 *            pour modifier les données de utilisateur
	 */

	private void modifierProfil() { // TODO Auto-generated method stub
		//////// ENCOURS
		/**
		 * user.setUser(); user.getUsers(); System.out.println("Nom : " +
		 * user[userId][0]); System.out.println("Prénom : " + user[userId][1]);
		 * System.out.println("Pays de résidence : " + users[userId][2]);
		 * System.out.println("Né(e) le : " + user[userId][3] + "\n");
		 */
	}

	/**
	 * 
	 * @param utilisateur
	 */

	private void showProfil() { // TODO EN COURS

		System.out.println(currentUser.getNom());
		System.out.println(currentUser.getPrenom());
		System.out.println(currentUser.getDateNaissance());
		System.out.println(currentUser.getPays());

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

		System.out.println("Que souhaitez vous faire aujourd'hui? (Tapez le chiffre correpondant)\n");

		System.out.println("1- Affichez votre profil");

		System.out.println("2- Modifier vos informations ");

		System.out.println("3- Ecrire un message");

		System.out.println("4- Afficher un message");

		System.out.println("5- Ajouter un ami");

		System.out.println("6- Afficher votre liste d'ami");
		System.out.println("7- Supprimer un ami");

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
		case 7:

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
