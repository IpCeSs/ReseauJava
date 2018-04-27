package com.cess.ReseauJAva2604;

import java.util.Scanner;

public class Post {
	  
	private int msgId=-1;
	 
	// private int longTableau=messages.length;
	private String auteur, body, titre;
	
	public Post() {
		
		String messages[][]=new String[9][3];
		 msgId=0;
		 messages[msgId][0]=auteur;
		 messages[msgId][1]=titre;
		 messages[msgId][2]=body;
	 
	}

	public int getMsgId() {
		return msgId;
	}


	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	//public int getLongTableau() {
	//	return longTableau;
	//}

//	public void setLongTableau(int longTableau) {
	//	this.longTableau = longTableau;
	//}
	

}
