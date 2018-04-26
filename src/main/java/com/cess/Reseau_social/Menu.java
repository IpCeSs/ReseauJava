package com.cess.Reseau_social;

import java.util.Scanner;

public class Menu {
	/**
	 * 
	 * @param utilisateur
	 */

	public void Menu(Utilisateur utilisateur) {

		Scanner sc = new Scanner(System.in);
		System.out.println("\nWelcome to CessSpot \n");

		boolean afficherMenu = true;

		while (afficherMenu) {

			System.out.println("Que souhaitez vous faire aujourd'hui? (Tapez le chiffre correpondant)\n");

			// System.out.println("9- Créer un compte");

			System.out.println("1- Affichez votre profil");

			// System.out.println("2- Modifier vos informations ");

			System.out.println("3- Ecrire un message");

			System.out.println("4- Afficher un message");

			// System.out.println("5- Ajouter un ami");

			// System.out.println("6- Afficher votre liste d'ami");

			System.out.println("0- Quitter CessSpot");

			int choix = sc.nextInt();
			sc.nextLine();
			// System.out.println("Bienvenue sur CessSpot "+ prenom +" "+nom);

			switch (choix)

			{

			case 1:

				showProfil(utilisateur);

				break;

			case 2:

				modifierProfil(utilisateur);

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

			case 9:

				newUser();

			}

			afficherMenu = retour();

		} // fin while

	}
	/*
	 * @return : true si on retourne au menu sinon false 
	 */

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
	  
	//  System.out.println("Quel est votre pays de résidence ?"); pays=sc.nextLine();
	//  users[userId][2]=pays;
	  
	  System.out.println("Quel est votre date de naissance ?");
	//  dateNaiss=sc.nextLine(); users[userId][3]=dateNaiss;
	  
	  
	  
	  }
	  
	  private void displayFriend() { // TODO Auto-generated method stub
	 // System.out.println("Amis de " + users[1][1]); System.out.println( amis[0][1]
	 // + " " + amis[0][0] + " pays de résidence : " + amis[0][3] + " est né(e) le "
	 // + amis[0][4]);
	  
	  }
	  
	  private void addFriend() { // TODO Auto-generated method stub
	  
	  }
	  
	  private void read() { // TODO Auto-generated method stub
	//  System.out.println("Message de : " + messages[msgId][0]);
	//  System.out.println("Titre : " + " " + messages[0][1]);
	//  System.out.println("Message :" + " " + messages[0][2]);
	  
	  }
	  
	  private void write() { Scanner sc = new Scanner(System.in); 
	  
	  // à chaque execution de la méthode, on incrémente le compteur userId
	//  msgId++;
	  
	 // System.out.println("Auteur du message"); auteur=sc.nextLine();
	 // messages[msgId][0]=auteur; 
	  
	 // System.out.println("Titre du message"); titre=sc.nextLine();
	//  messages[msgId][1]=titre;
	  
	 // System.out.println("Contenu du message"); body=sc.nextLine();
	//[msgId][2]=body;
	  
	  
	  
	  }
	  
	  /**
	   * 
	   * @param utilisateur
	   */
	  
	  private void modifierProfil(Utilisateur utilisateur) { // TODO Auto-generated method stub
	  
	  }
	  
	  /**
	   * 
	   * @param utilisateur
	   */
	  
	  private void showProfil(Utilisateur utilisateur) { // TODO Auto-generated method stub
	  
	  System.out.println("Profil de " + utilisateur.getPrenom() + " " + utilisateur.getNom());
	  System.out.println("Né(e) le" + " " + utilisateur.getDateNaissance());
	  System.out.println("Pays de Résidence" + " " + utilisateur.getPays());
	  
	  }
	  
	  private void exit() { // TODO Auto-generated method stub4
	  System.out.println("A bientôt sur CessSpot!!"); }

}