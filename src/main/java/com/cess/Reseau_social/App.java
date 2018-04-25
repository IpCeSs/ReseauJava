package com.cess.Reseau_social;

import java.util.Scanner;

//import java.util.Scanner;

public class App {
	// création d'un tableau utilisateurs
	static String users[][] = { { "Ip", "Cess", "cess@cess.com", "Canada", "14 mai 1986" },
			{ "NewHouse", "Vincent", "new@house.com", "France", "26 juin 1978 " } };
	// static String users[][] = new String[4][6];
	static String messages[][] = { { users[0][0], users[0][1], "Hello You!",
			"Coucou comment tu vas ça fait longtemps que je ne t'ai pas vu!! Trop contente de te retrouver sur CessSpot!! Bisous" } };
	static String amis[][] = { { "Ip", "Cess", "cess@cess.com", "Canada", "14 mai 1986" } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("\nWelcome to CessSpot \n");
		
boolean afficherMenu = true;
        
        while(afficherMenu) {

		System.out.println("Que souhaitez vous faire aujourd'hui? (Tapez le chiffre correpondant)\n");

		System.out.println("9- Créer un compte");

		System.out.println("1- Affichez votre profil");

		System.out.println("2- Modifier vos informations ");

		System.out.println("3- Ecrire un message");

		System.out.println("4- Afficher un message");

		System.out.println("5- Ajouter un ami");

		System.out.println("6- Afficher le nom d'un ami");

		System.out.println("0- Quitter CessSpot");

		int choix = sc.nextInt();
		  sc.nextLine();//après nextInt toujours mettre Next line car "entrée" crée une string

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

		case 9:

		//	newUser();

		}
		
		afficherMenu = retour();
		
        }//fin while
		
		

	}

	private static void displayFriend() {
		// TODO Auto-generated method stub
		System.out.println("Amis de " + users[1][1]);
		System.out.println(
				amis[0][1] + " " + amis[0][0] + " pays de résidence : " + amis[0][3] + " est né(e) le " + amis[0][4]);

		
	}

	private static void addFriend() {
		// TODO Auto-generated method stub
		
	}

	private static void read() {
		// TODO Auto-generated method stub
		System.out.println("Message de : " + messages[0][0] + " " + messages[0][1]);
		System.out.println("Titre : " + " " + messages[0][2]);
		System.out.println("Message :" + " " + messages[0][3]);
		

	}

	private static void write() {
		// TODO Auto-generated method stub

		
	}

	private static void modifierProfil() {
		// TODO Auto-generated method stub
		
	}

	private static void showProfil() {
		// TODO Auto-generated method stub

		System.out.println("Profil de " + users[1][0] + " " + users[1][1]);
		System.out.println("Né(e) le" + " " + users[1][4]);
		System.out.println("Pays de Résidence" + " " + users[1][4]);
		

	}

	private static void exit() {
		// TODO Auto-generated method stub4
		System.out.println("A bientôt sur CessSpot!!");
	}

	// fonction permettant de retourner au menu : 
	/**
    * Demande a l'utilisateur si il faut returner au menu ou quiter
    * @return : true si on retourne au menu sinon false 
    */
	public static boolean retour() {
		 System.out.println("Retourner au menu ? ");
	        return demanderOuiNon();

	}
	private static boolean demanderOuiNon() {
        char r;
        Scanner ret = new Scanner(System.in);
        do {
            System.out.println("Répondre par O / N");
            r = ret.nextLine().charAt(0);
        } while( r != 'O' && r != 'N');
        if(r == 'O') {
            return true;
        } else {
            return false;
        }
    }
}
