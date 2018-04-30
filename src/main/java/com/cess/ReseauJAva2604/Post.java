package com.cess.ReseauJAva2604;

import java.util.Scanner;

public class Post {

	private int msgId = 0;
	String messages[][] = new String[10][3];

	private String auteur = " ";

	private String body = " ";

	private String titre = " ";

	public Post() {

	}

	public void setpost() {
		Scanner sc = new Scanner(System.in);
		/**
		 * on déclare les variables que l'on va récupérer avec la saisie clavier et
		 * utiliser dans le tableau String auteur,body, titre;
		 */

		// à chaque execution de la méthode, on incrémente le compteur messageId
		int id = getMsgId();
		System.out.println("Auteur du message");
		auteur = sc.nextLine();
		messages[id][0] = auteur;

		System.out.println("Titre du message");
		titre = sc.nextLine();
		messages[id][1] = titre;

		System.out.println("Contenu du message");
		body = sc.nextLine();
		messages[id][2] = body;
		id++;

	}

	/**
	 * @info permet de récupérer la valeur du tableau crée grâce à setPost
	 * @return
	 */

	public String[][] getPost() {
		return this.messages;
	}

	public int getMsgId() {
		return this.msgId;
	}

}
